import { Module } from "@nestjs/common";
import { User } from "../users/entities/users.entity";
import { TypeOrmModule } from "@nestjs/typeorm";
import { UsersModule } from "../users/users.module";
import { AuthController } from "./auth.controller";
import { AuthService } from "./auth.service";
import { JwtModule } from "@nestjs/jwt";

@Module({
    imports: [
        TypeOrmModule.forFeature([User]),
        UsersModule,
        JwtModule.register({
            global: true,
            secret: '',
            signOptions: { expiresIn: '60s' }
        }),
    ],
    providers: [AuthService],
    controllers: [AuthController]
})


export class AuthModule {}