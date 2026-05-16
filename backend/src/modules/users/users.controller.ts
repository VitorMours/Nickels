import { Controller, Get, Post, Param, Req } from '@nestjs/common'; 
import type { Request, Response } from 'express';
import type { UserService } from './users.service';


@Controller('users')
export class UsersController {
  constructor(private readonly userService: UserService){}

  @Get()
  findAll(@Req() request: Request): string {
    return 'Find All users';
  }

  @Get(':id')
  findOne(@Req() request: Request, @Param() id: string): string {
    return 'Find one user';
  }

}
