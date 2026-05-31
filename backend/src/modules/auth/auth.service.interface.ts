import { User } from "../users/entities/users.entity";
import { CreateLoginDto } from "./dto/auth.create-login.dto";
import { CreateSigninDto } from "./dto/auth.crete-signin.dto";



export interface AuthServiceInterface{
    createLogin(data: CreateLoginDto): Promise<User | null>;
    createSignin(data: CreateSigninDto): Promise<User | null>;
}
