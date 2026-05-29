import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { AccountService } from "./account.service";
import { AccountControllers } from "./account.controller";


@Module({
  imports: [TypeOrmModule.forFeature([])],
  controllers: [AccountControllers],
  providers: [AccountService]
  
})

export class AccountModule {}