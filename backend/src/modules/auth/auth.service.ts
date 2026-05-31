import { InjectRepository } from "@nestjs/typeorm";
import { User } from "../users/entities/users.entity";
import { AuthServiceInterface } from "./auth.service.interface";
import { CreateLoginDto } from "./dto/auth.create-login.dto";
import { CreateSigninDto } from "./dto/auth.crete-signin.dto";
import { Injectable, NotFoundException } from "@nestjs/common";
import { UsersService } from "../users/users.service";

@Injectable()
export class AuthService implements AuthServiceInterface {
    constructor(private usersService: UsersService){}

    async createSignin(data: CreateSigninDto): Promise<User | null> {
        try{
            const user = await this.usersService.findOneByEmail(data.email);
            if(user) {
                throw new NotFoundException("User with this email already exists")
            }
            const newUser = await this.usersService.create({
                firstName: data.firstName,
                email: data.email,
                password: data.password
            });
            return newUser;
        }catch(error){
            return null;
        }
    }

    async createLogin(data: CreateLoginDto): Promise<User | null> {
        try{
            const user = await this.usersService.findOneByEmail(data.email);
            if(!user) {
                throw new NotFoundException("User with this email does not exists")
            }
            if(data.password !== user.password){
                throw new NotFoundException("Incorrect password");
            }
            return user;
        } catch (error) {
            return null;
        }
    }
}
