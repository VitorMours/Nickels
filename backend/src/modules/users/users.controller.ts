import { Controller, Get, Post, Delete, Patch, HttpCode, Body, Param } from "@nestjs/common";
import { UsersService } from "./users.service";
import { CreateUserDto } from "./dto/users.create-user.dto";
import type { UpdateUserDto } from "./dto/users.update-user.dto";

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

  @HttpCode(200)
  @Patch(':id')
  public updateUser(@Param('id') id:number, @Body() updateUserDto: UpdateUserDto){
    return this.usersService.update(id, updateUserDto);
  }

  @HttpCode(204)
  @Delete()
  public deleteUser(@Param('id') id: number){
    return this.usersService.delete(id);
  }
}