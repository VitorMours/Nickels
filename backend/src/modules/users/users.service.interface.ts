import type { CreateUserDto } from "./dto/users.create-user.dto";
import type { User } from "./entities/users.entity";

export interface UserServiceInterface {
  findAll(): Promise<User[]>;
  findOne(id: number): Promise<User | null>;
  create(user: CreateUserDto): Promise<User>;
  delete(id: number): void;
}