import { Module } from '@nestjs/common';
import { databaseProviders } from './database/database.provider';
import { UsersModule } from './modules/users/users.module';

@Module({
//  providers: [...databaseProviders],
//  exports: [...databaseProviders],
  imports: [UsersModule],
})
export class AppModule {}
