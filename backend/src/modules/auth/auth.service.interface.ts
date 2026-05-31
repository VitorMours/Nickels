import { User } from "../users/entities/users.entity";
import { CreateLoginDto } from "./dto/auth.create-login.dto";



export interface AuthServiceInterface{
    createLogin(data: CreateLoginDto): Promise<User | null>;


}
