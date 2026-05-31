import { User } from "../users/entities/users.entity";
import { AuthServiceInterface } from "./auth.service.interface";
import { CreateLoginDto } from "./dto/auth.create-login.dto";

class AuthService implements AuthServiceInterface {
    createLogin(data: CreateLoginDto): Promise<User | null> {
        throw new Error("Method not implemented.");
    }
}
