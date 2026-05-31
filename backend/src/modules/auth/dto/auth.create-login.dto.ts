import { IsEmail, MinLength } from "class-validator";

export class CreateLoginDto {
  @IsEmail()
  email!: string;

  @MinLength(6)
  password!: string;
}