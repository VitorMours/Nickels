import { Injectable } from "@nestjs/common";
import type { AccountServiceInterface } from "./account.service.interface";


@Injectable()
export class AccountService implements AccountServiceInterface{
  // constructor(@InjectRepository(Account) private accountRepository: Repository<Account>);


}