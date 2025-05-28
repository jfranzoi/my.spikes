import { NestFactory } from '@nestjs/core';
import { ConsoleLogger, LogLevel } from '@nestjs/common';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule, {
    logger: new ConsoleLogger({
      logLevels: (process.env.LOGGER_LEVELS ?? "log,warn,error,fatal").split(",") as LogLevel[],
      json: (process.env.LOGGER_JSON ?? "false") == "true",
    }),
  });
  await app.listen(process.env.PORT ?? 3000);
}
void bootstrap();
