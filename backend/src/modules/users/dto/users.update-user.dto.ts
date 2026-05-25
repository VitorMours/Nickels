import { ApiPropertyOptional } from "@nestjs/swagger";
import { IsString, IsEmail, MinLength, IsOptional } from "class-validator";

export class UpdateUserDto {
  @ApiPropertyOptional({ example: 'João' }) // Caso não use o plugin
  @IsString()
  @IsOptional()
  firstName?: string;
  
  @ApiPropertyOptional({ example: 'Silva' }) // Caso não use o plugin
  @IsString()
  @IsOptional()
  lastName?: string;

  @ApiPropertyOptional({ example: 'joao@email.com' }) // Caso não use o plugin
  @IsEmail()
  @IsOptional() // Adicionado: em um Update, geralmente o email também é opcional
  email?: string; // Removido o '!' e adicionado o '?'
  
  @ApiPropertyOptional({ minLength: 6, example: 'novaSenha123' }) // Caso não use o plugin
  @IsString()
  @MinLength(6)
  @IsOptional() // Adicionado: o usuário só envia a senha se quiser trocá-la
  password?: string; // Removido o '!' e adicionado o '?'
}