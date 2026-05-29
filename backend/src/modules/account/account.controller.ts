import { Controller, HttpCode, Get, Post, Patch, Delete } from "@nestjs/common";
import { AccountService } from "./account.service";
  


@Controller("accounts")
export class AccountControllers {
  constructor(private readonly accountService: AccountService){}

  @HttpCode(200)
  @Get()
  public async getAccounts(): Promise<Account[]> {
    return await this.accountService.findAll();
  }

  @HttpCode(200)
  @Get(':id')
  public async getAccountById(@Param('id') id: number) : Promise<Account | null> {
    return await this.accountService.findOne(id);
  }

}
