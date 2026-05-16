import { Controller, Get, Post, Param, Req } from '@nestjs/common'; 
import type { Request, Response } from 'express';


@Controller('users')
export class UsersController {

  @Get()
  findAll(@Req() request: Request): string {
    return 'Find All users';
  }

  @Get(':id')
  findOne(@Req() request: Request, @Param() id: string): string {
    return 'Find one user';
  }

}
