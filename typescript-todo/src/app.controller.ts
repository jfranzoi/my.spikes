import {
  Controller,
  Get,
  HttpRedirectResponse,
  Logger,
  Param,
  Query,
  Redirect,
} from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  private readonly logger = new Logger(AppController.name);

  constructor(private readonly appService: AppService) {
    this.logger.verbose('Init');
  }

  @Get()
  promisedHello(@Query() query?: unknown) {
    this.logger.debug('query', query);
    return this.appService.getHello();
  }

  @Get('hello/:name')
  helloTo(@Param('name') name: string) {
    return `Hello, ${name}`;
  }

  @Get('goto')
  @Redirect()
  redirection(): HttpRedirectResponse {
    return {
      statusCode: 302,
      url: '/',
    };
  }
}
