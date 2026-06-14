import { Controller, HttpCode, Get, Post, Patch, Delete, Param, Body } from "@nestjs/common";
import { AccountService } from "./account.service";
import Account from "./entities/account.entity";
import { CreateAccountDto } from "./dto/account.create-account.dto";
import { UpdateAccountDto } from "./dto/account.update-account.dto";
import { ApiTags } from "@nestjs/swagger";

@ApiTags('accounts')
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

  @HttpCode(201)
  @Post()
  public async createAccount(@Body() account: CreateAccountDto) : Promise<Account> {
    return await this.accountService.createAccount(account);
  }

  @HttpCode(200)
  @Patch(':id')
  public async updateAccountById(@Param('id') id: number, @Body() account: UpdateAccountDto) : Promise<Account | null> {
    return await this.accountService.updateById(id, account);
  }

  @HttpCode(204)
  @Delete(':id')
  public async deleteAccountById(@Param('id') id: number) : Promise<void> {
    return await this.accountService.deleteAccountById(id);
  }
}
