import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { SwaggerModule } from 'node_modules/@nestjs/swagger/dist/swagger-module';
import { DocumentBuilder } from 'node_modules/@nestjs/swagger/dist/document-builder';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  
  const config = new DocumentBuilder()
    .setTitle('Nickels API')
    .setDescription('The Nickels API description')
    .setVersion('1.0')
    .addTag('nickels')
    .build();
  const documentFactory = () => SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('docs', app, documentFactory);
  
  await app.listen(process.env.PORT ?? 8080);
}
bootstrap();
