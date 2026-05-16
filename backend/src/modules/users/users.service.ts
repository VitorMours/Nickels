import { Injectable } from "@nestjs/common";
import type { UserServiceInterface } from "./users.service.interface";
import type { CreateUserDto } from "./dto/users.create-user.dto";
import type { User } from "./entities/users.entity";

@Injectable()
export class UsersService implements UserServiceInterface{
  
  findAll(): Promise<User[]> {
    throw new Error("Method not implemented.");
  }
  findOne(id: number): Promise<User | null> {
    throw new Error("Method not implemented.");
  }
  create(user: CreateUserDto): Promise<User> {
    throw new Error("Method not implemented.");
  }
}