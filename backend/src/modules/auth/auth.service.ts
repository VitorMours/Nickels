import { InjectRepository } from "@nestjs/typeorm";
import { User } from "../users/entities/users.entity";
import { AuthServiceInterface } from "./auth.service.interface";
import { CreateLoginDto } from "./dto/auth.create-login.dto";
import { CreateSigninDto } from "./dto/auth.create-signin.dto";
import { Injectable, NotFoundException } from "@nestjs/common";
import { UsersService } from "../users/users.service";
import { JwtService } from "@nestjs/jwt";

@Injectable()
export class AuthService implements AuthServiceInterface {
    constructor(private usersService: UsersService, private jwtService: JwtService){}

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

    async createLogin(data: CreateLoginDto): Promise<{ access_token : string } | null> {
        try{
            const user = await this.usersService.findOneByEmail(data.email);
            if(!user) {
                throw new NotFoundException("User with this email does not exists")
            }
            if(data.password !== user.password){
                throw new NotFoundException("Incorrect password");
            }
            const payload = { email: data.email, password: data.password}
            return {access_token: await this.jwtService.signAsync(payload)};
        } catch (error) {
            return null;
        }
    }
}
