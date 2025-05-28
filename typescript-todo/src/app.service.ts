import { Injectable, Logger } from '@nestjs/common';

@Injectable()
export class AppService {
  private readonly logger = new Logger(AppService.name);

  constructor() {
    this.logger.verbose('Init');
  }

  getHello(): string {
    return 'Hello World!';
  }
}
