import { MiddlewareConsumer, Module, NestModule } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';

import { UsersModule } from './modules/users/users.module';
import { AccountModule } from './modules/account/account.module'; 
import { AuthModule } from './modules/auth/auth.module';
import { LoggerService } from './common/services/logger.service';
import { AppLoggerMiddleware } from './common/middlewares/appLogger.middleware';


@Module({
  providers: [LoggerService],
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
    }),

    TypeOrmModule.forRoot({
      type: 'postgres',

      host: process.env.DB_HOST,
      port: Number(process.env.DB_PORT),

      username: process.env.DB_USER,
      password: process.env.DB_PASSWORD,
      database: process.env.DB_NAME,

      autoLoadEntities: true,
      synchronize: true,
    }),

    UsersModule,
    AccountModule,
    AuthModule,
  ],
})
export class AppModule implements NestModule {
    configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(AppLoggerMiddleware)
      .forRoutes('*'); 
  }
}
