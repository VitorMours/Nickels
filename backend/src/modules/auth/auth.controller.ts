import { Controller, HttpCode, Get, Post, Patch, Delete, BadRequestException, Body } from "@nestjs/common";
import { AuthService } from "./auth.service";
import { CreateLoginDto } from "./dto/auth.create-login.dto";
import { User } from "../users/entities/users.entity";
import { CreateSigninDto } from "./dto/auth.create-signin.dto";
import { ApiBody, ApiResponse, ApiTags } from "@nestjs/swagger";

@ApiTags('auth')
@Controller('auth')
export class AuthController {

    constructor(private readonly authService: AuthService){}

    @HttpCode(201)
    @Post('login')
    @ApiBody({ type: CreateLoginDto })
    @ApiResponse({ status: 201, description: 'Access token created'})
    public async login(@Body() dto: CreateLoginDto) {
        return await this.authService.createLogin(dto);
        
    }

    @HttpCode(201)
    @Post('signin')
    @ApiBody({ type: CreateSigninDto })
    @ApiResponse({ status: 201, description: 'Successful sign in'})
    public async signin(@Body() dto: CreateSigninDto): Promise<User | null> {
        return await this.authService.createSignin(dto);
    }
}