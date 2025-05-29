import { NestFactory } from '@nestjs/core';
import { ConsoleLogger, LogLevel } from '@nestjs/common';
import { AppModule } from './app/app.module';
import * as dotenv from 'dotenv';

function logger() {
  return new ConsoleLogger({
    logLevels: (process.env.LOGGER_LEVELS ?? 'log,warn,error,fatal').split(
      ',',
    ) as LogLevel[],
    json: (process.env.LOGGER_JSON ?? 'false') == 'true',
  });
}

async function bootstrap() {
  dotenv.config(); // force .env loading, when available
  const app = await NestFactory.create(AppModule, { logger: logger() });
  await app.listen(process.env.PORT ?? 3000);
}

void bootstrap();
