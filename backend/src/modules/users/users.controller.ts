import { Controller, Get, Post, Patch, Delete, HttpCode, Body, Param } from "@nestjs/common";
import { ApiBody, ApiResponse, ApiTags } from "@nestjs/swagger";
import { UsersService } from "./users.service";
import { CreateUserDto } from "./dto/users.create-user.dto";
import type { User } from "./entities/users.entity";
import { UpdateUserDto } from "./dto/users.update-user.dto";

@ApiTags('users')
@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @HttpCode(200)
  @Get()
  public async getUsers(): Promise<User[]> {
    return await this.usersService.findAll();
  }

  @HttpCode(200)
  @Get(':id')
  @ApiResponse({ status: 200, description: 'User found successfully' })
  public async getUserById(@Param('id') id: number): Promise<User | null> {
    return await this.usersService.findOne(id);
  }

  @HttpCode(201)
  @Post()
  @ApiBody({ type: CreateUserDto })
  @ApiResponse({ status: 201, description: 'User created successfully' })
  public async createUser(@Body() createUserDto: CreateUserDto): Promise<User>{
    return await this.usersService.create(createUserDto)
  }

  @HttpCode(201)
  @Patch(':id')
  @ApiBody({ type: UpdateUserDto })
  @ApiResponse({ status: 201, description: 'User Updated successfully'})
  public async updateUser(@Param('id') id: number, @Body() updateUserDto: UpdateUserDto): Promise<User | null>{
    return await this.usersService.update(id, updateUserDto)
  }

  @HttpCode(204)
  @Delete(':id')
  @ApiResponse({ status: 204, description: 'User deleted successfully' })
  public async deleteUser(@Param('id') id: number): Promise<void>{
    return await this.usersService.delete(id);
  }
}