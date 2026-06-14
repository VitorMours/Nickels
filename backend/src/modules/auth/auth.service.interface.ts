import { User } from "../users/entities/users.entity";
import { CreateLoginDto } from "./dto/auth.create-login.dto";
import { CreateSigninDto } from "./dto/auth.create-signin.dto";



export interface AuthServiceInterface{
    createLogin(data: CreateLoginDto): Promise<{ access_token: string } | null>;
    createSignin(data: CreateSigninDto): Promise<User | null>;
}
