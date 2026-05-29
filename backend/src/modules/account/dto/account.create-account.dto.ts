import { IsString, IsEmail, MinLength, IsInt } from 'class-validator';
import { User } from 'src/modules/users/entities/users.entity';

export class CreateAccountDto {
    
    @IsString()
    @MinLength(3)
    accountName!: string;

    @IsInt()
    user!: User[] | User;
}