import { IsString, IsEmail, MinLength, IsOptional } from "class-validator";

export class CreateUserDto {
  /**
   * Primeiro nome do usuário
   * @example 'João'
   */
  @IsString()
  firstName: string; // O plugin detecta como obrigatório

  /**
   * Sobrenome do usuário
   * @example 'Silva'
   */
  @IsString()
  @IsOptional() // Adicione isso para o class-validator e o Swagger saberem que é opcional
  lastName?: string;

  /**
   * E-mail único para login
   * @example 'joao@email.com'
   */
  @IsEmail()
  email: string;
  
  /**
   * Senha de acesso (mínimo 6 caracteres)
   * @example 'senha123'
   */
  @IsString()
  @MinLength(6) // O plugin adiciona automaticamente a restrição de "minLength: 6" no Swagger
  password: string;
}