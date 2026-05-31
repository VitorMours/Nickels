import { Controller, HttpCode, Get, Post, Patch, Delete, BadRequestException } from "@nestjs/common";
import { AuthService } from "./auth.service";
import { CreateLoginDto } from "./dto/auth.create-login.dto";
import { User } from "../users/entities/users.entity";
import { CreateSigninDto } from "./dto/auth.crete-signin.dto";

@Controller('auth')
export class AuthController {

    constructor(private readonly authService: AuthService){}

    @HttpCode(200)
    @Post('login')
    public async login(dto: CreateLoginDto) {
        const user = await this.authService.createLogin(dto);
        if(!user) {
            throw new BadRequestException("Invalid credentials");
        }
        return user;
    }

    @HttpCode(201)
    @Post('signin')
    public async signin(dto: CreateSigninDto) : Promise<User | null> {
        return await this.authService.createSignin(dto);
    }
}