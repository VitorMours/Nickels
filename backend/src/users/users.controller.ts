import { Controller, Get, Param, Post, Patch, Delete } from '@nestjs/common';

@Controller('users')
export class UserController {
  @Get(':id')
  async getUserById(@Param('id') id: string) {
    return await { id: '12' };
  }
}
