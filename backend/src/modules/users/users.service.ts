import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm"; 
import { Repository } from "typeorm";
import type { UserServiceInterface } from "./users.service.interface";
import type { CreateUserDto } from "./dto/users.create-user.dto";
import { User } from "./entities/users.entity";
import type { UpdateUserDto } from "./dto/users.update-user.dto";

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

  async update(id: number, user: UpdateUserDto): Promise<User | null> {
    const userToUpdate = await this.userRepository.findOneBy({ id });
    if (!userToUpdate) {
      return Promise.resolve(null);
    }
    const updatedUser = this.userRepository.merge(userToUpdate, user);
    return this.userRepository.save(updatedUser);
  }
  
  delete(id: number): void{
    this.userRepository.delete(id);
  }
}