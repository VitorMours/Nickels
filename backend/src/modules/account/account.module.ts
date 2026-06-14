import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { AccountService } from "./account.service";
import { AccountControllers } from "./account.controller";
import Account from "./entities/account.entity";

@Module({
  imports: [TypeOrmModule.forFeature([Account])],
  controllers: [AccountControllers],
  providers: [AccountService]
  
})

export class AccountModule {}
