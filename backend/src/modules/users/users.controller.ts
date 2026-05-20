import { Controller, Get, Post, Delete, HttpCode, Body, Param } from "@nestjs/common";
import { UsersService } from "./users.service";
import { CreateUserDto } from "./dto/users.create-user.dto";

@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @HttpCode(200)
  @Get()
  public getUsers(){
    return this.usersService.findAll();
  }

  @HttpCode(200)
  @Get(':id')
  public getUserById(@Param('id') id: number){
    return this.usersService.findOne(id);  
  }

  @HttpCode(201)
  @Post()
  public createUser(@Body() createUserDto: CreateUserDto){
    return this.usersService.create(createUserDto)
  }

  @HttpCode(204)
  @Delete()
  public deleteUser(@Param('id') id: number){
    return this.usersService.delete(id);
  }
}