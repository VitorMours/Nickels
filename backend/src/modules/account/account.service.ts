import { Injectable } from "@nestjs/common";
import type { AccountServiceInterface } from "./account.service.interface";
import { Account } from "./entities/account.entity";
import { Repository } from "typeorm";
import { InjectRepository } from "@nestjs/typeorm";
import { CreateAccountDto } from "./dto/account.create-account.dto";
import { UpdateAccountDto } from "./dto/account.update-account.dto";


@Injectable()
export class AccountService implements AccountServiceInterface{
  constructor(@InjectRepository(Account) private accountRepository: Repository<Account>){}
  
  async createAccount(id: number, dto: CreateAccountDto): Promise<Account | null> {
    const newAccount = this.accountRepository.create(dto);
    return await this.accountRepository.save(newAccount);
  }
  
  async findAll(): Promise<Account[]> {
    return await this.accountRepository.find();
  }

  async findOne(id: number): Promise<Account | null> {
    return await this.accountRepository.findOneBy({ id });
  }

  async updateById(id: number, dto: UpdateAccountDto): Promise<Account | null> {
    throw new Error("Method not implemented.");
  }

  deleteById(): void {
    throw new Error("Method not implemented.");
  }
}