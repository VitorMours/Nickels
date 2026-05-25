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

  async findAll(): Promise<User[]> {
    return await this.userRepository.find();
  }

  async findOne(id: number): Promise<User | null> {
    return await this.userRepository.findOneBy({ id });
  }

  async create(user: CreateUserDto): Promise<User> {
    const newUser = this.userRepository.create(user);
    return await this.userRepository.save(newUser);
  }

  async update(id: number, user: UpdateUserDto): Promise<User | null> {
    try{  
      const findUser = await this.userRepository.findOneBy({ id });
      
      if(!findUser){
        throw new Error("Was not possible to find the user")
      }
      Object.assign(findUser, user);
      return await this.userRepository.save(findUser);

    }catch(error){
      return null;
    }
  }

  async delete(id: number): Promise<void> {
    await this.userRepository.delete(id);
  }
}