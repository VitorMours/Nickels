import { Injectable, NestMiddleware } from '@nestjs/common';
import { Request, Response, NextFunction } from 'express';
import { LogLevel } from "../enums/log-level.enum";
import { LoggerService } from '../services/logger.service';


@Injectable()
export class AppLoggerMiddleware implements NestMiddleware {
  constructor(private readonly loggerService: LoggerService) { }

  use(req: Request, res: Response, next: NextFunction) {
    const { method, originalUrl, headers, body } = req;
    const startTime = Date.now();

    this.loggerService.debug('Incoming headers', {
      method,
      url: originalUrl,
      headers: this.sanitizeHeaders(headers),
    });

    this.loggerService.debug('Request body', { body: this.sanitizeBody(body) });

    res.on('finish', () => {
      const duration = Date.now() - startTime;
      const { statusCode } = res;

      this.loggerService.info(`${method} ${originalUrl} ${statusCode} — ${duration}ms`);

      // WARN: loga quando a resposta demorou muito
      if (duration > 1000) {
        this.loggerService.warn(`Resposta lenta detectada`, {
          method,
          url: originalUrl,
          duration,
        });
      }
    });
    next();
  }

  private sanitizeHeaders(headers: Record<string, unknown>) {
    const { authorization, cookie, ...safe } = headers;
    return safe;
  }

  private sanitizeBody(body: Record<string, unknown>) {
    const sensitive = ['password', 'senha', 'token', 'secret', 'creditCard'];
    const sanitized = { ...body };
    for (const field of sensitive) {
      if (field in sanitized) sanitized[field] = '***';
    }
    return sanitized;
  }

}