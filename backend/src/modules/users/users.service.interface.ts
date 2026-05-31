import type { CreateUserDto } from "./dto/users.create-user.dto";
import type { UpdateUserDto } from "./dto/users.update-user.dto";
import type { User } from "./entities/users.entity";

export interface UserServiceInterface {
  findAll(): Promise<User[]>;
  findOne(id: number): Promise<User | null>;
  findOneByEmail(email: string): Promise<User | null>;
  create(user: CreateUserDto): Promise<User>;
  update(id: number, user: UpdateUserDto): Promise<User | null>;
  delete(id: number): void;
}