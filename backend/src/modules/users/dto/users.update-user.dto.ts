import { IsString, IsEmail, MinLength } from "class-validator";

export class UpdateUserDto {
  @IsString()
  firstName!: string;

  @IsString()
  lastName?: string;

  @IsString()
  @MinLength(6)
  password!: string;
}