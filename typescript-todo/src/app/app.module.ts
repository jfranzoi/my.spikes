import {
  Logger,
  MiddlewareConsumer,
  Module,
  NestModule,
  Scope,
} from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { Request, Response, NextFunction } from 'express';

@Module({
  imports: [],
  controllers: [AppController],
  providers: [
    { provide: AppService, useClass: AppService, scope: Scope.REQUEST },
  ],
})
export class AppModule implements NestModule {
  private readonly logger = new Logger(AppModule.name);

  constructor() {
    this.logger.verbose('Init');
  }

  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply((req: Request, res: Response, next: NextFunction) => {
        this.logger.verbose(
          `Request: ${req.url}, response: ${res.getHeaderNames().join(', ')}`,
        );
        next();
      })
      .forRoutes('*');
  }
}
