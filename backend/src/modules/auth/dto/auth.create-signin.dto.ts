import { IsEmail, IsString, MinLength } from "class-validator";
import { ApiProperty } from "@nestjs/swagger";

export class CreateSigninDto {
    @ApiProperty({ example: 'Vitor MOura' })
    @IsString()
    firstName!: string;
    
    @ApiProperty({ example: 'example@example.com' })
    @IsEmail()
    email!: string;
    
    @ApiProperty({ minLength: 6, example: 'novaSenha123'})
    @MinLength(6)
    password!: string;

}