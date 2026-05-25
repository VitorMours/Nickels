import { ApiPropertyOptional } from "@nestjs/swagger";
import { IsString, IsEmail, MinLength, IsOptional } from "class-validator";

export class CreateUserDto {
  /**
   * Primeiro nome do usuário
   * @example 'João'
   */
  @ApiPropertyOptional({ example: 'John' }) // Caso não use o plugin
  @IsString()
  firstName: string; // O plugin detecta como obrigatório

  /**
   * Sobrenome do usuário
   * @example 'Silva'
   */
  @ApiPropertyOptional({ example: 'Doe' }) // Caso não use o plugin
  @IsString()
  @IsOptional() // Adicione isso para o class-validator e o Swagger saberem que é opcional
  lastName?: string;

  /**
   * E-mail único para login
   * @example 'joao@email.com'
   */
  @ApiPropertyOptional({ example: 'joao@email.com' }) // Caso não use o plugin
  @IsEmail()
  email: string;
  
  /**
   * Senha de acesso (mínimo 6 caracteres)
   * @example 'senha123'
   */
  @ApiPropertyOptional({ minLength: 6, example: 'novaSenha123' }) // Caso não use o plugin
  @IsString()
  @MinLength(6) // O plugin adiciona automaticamente a restrição de "minLength: 6" no Swagger
  password: string;
}