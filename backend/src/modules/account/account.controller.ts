import { Controller } from "@nestjs/common";
import { AccountService } from "./account.service";

@Controller("accounts")
export class AccountControllers {

  constructor(private readonly accountService: AccountService){}

}