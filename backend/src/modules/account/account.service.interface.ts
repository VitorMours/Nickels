import { CreateAccountDto } from "./dto/account.create-account.dto";
import { UpdateAccountDto } from "./dto/account.update-account.dto";
import { Account } from "./entities/account.entity"


export interface AccountServiceInterface {
    findAll() : Promise<Account[]>;
    findOne(id: number) : Promise<Account | null>;
    updateById(id: number, dto: UpdateAccountDto) : Promise<Account | null>
    createAccount(dto: CreateAccountDto) : Promise<Account | null>
    deleteAccountById(id: number) : void;
}

