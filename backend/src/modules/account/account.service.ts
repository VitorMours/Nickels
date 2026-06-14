import { Injectable } from "@nestjs/common";
import type { AccountServiceInterface } from "./account.service.interface";
import Account from "./entities/account.entity";
import { Repository } from "typeorm";
import { InjectRepository } from "@nestjs/typeorm";
import { CreateAccountDto } from "./dto/account.create-account.dto";
import { UpdateAccountDto } from "./dto/account.update-account.dto";


@Injectable()
export class AccountService implements AccountServiceInterface{
  constructor(@InjectRepository(Account) private accountRepository: Repository<Account>){}
  
  async createAccount(dto: CreateAccountDto): Promise<Account> {
    const newAccount = this.accountRepository.create(dto);
    return await this.accountRepository.save(newAccount);
  }
  
  async findAll(): Promise<Account[]> {
    return await this.accountRepository.find();
  }

  async findOne(id: number): Promise<Account | null> {
    try{
      const findedOne = await this.accountRepository.findOneBy({ id });
      
      if(!findedOne){
        throw new Error("Was not possible to find the specified id user");
      }
      return findedOne;

    } catch(error) {
      console.log(error);
      return null;
    }
  }

  async updateById(id: number, dto: UpdateAccountDto): Promise<Account | null> {
    try{ 
      const findAccount = await this.accountRepository.findOneBy({ id });

      if(!findAccount){
        throw new Error("Was not possible to find the account with this id");
      }
      
      Object.assign(findAccount, dto);
      return await this.accountRepository.save(findAccount);
    
    } catch(error){
      console.log(error);
      return null;
    }
  }

  async deleteAccountById(id: number): Promise<void> {
    try{
      const findAccount = await this.accountRepository.findOneBy({ id });
      this.accountRepository.delete(id);

      if(!findAccount){
        throw new Error("Was not possible to even find this account by the id");
      }

    }catch(error){
      console.log(error);
    }
  }
}
