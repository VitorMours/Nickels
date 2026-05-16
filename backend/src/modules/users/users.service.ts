import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm"; 
import { Repository } from "typeorm";
import type { UserServiceInterface } from "./users.service.interface";
import type { CreateUserDto } from "./dto/users.create-user.dto";
import { User } from "./entities/users.entity";

@Injectable()
export class UsersService implements UserServiceInterface{
  constructor(@InjectRepository(User) private userRepository: Repository<User>){}

  findAll(): Promise<User[]> {
    return this.userRepository.find();
  }

  findOne(id: number): Promise<User | null> {
    return this.userRepository.findOneBy({ id });
  }

  create(user: CreateUserDto): Promise<User> {
    const newUser = this.userRepository.create(user);
    return this.userRepository.save(newUser);
  }
  
  delete(id: number): void{
    this.userRepository.delete(id);
  }
}