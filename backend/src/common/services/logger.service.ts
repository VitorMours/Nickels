import { Injectable } from "@nestjs/common";
import { LogLevel } from "../enums/log-level.enum";

@Injectable() 
export class LoggerService {
    private readonly level: LogLevel 

    constructor() {
        const envLevel = process.env.LOG_LEVEL?.toUpperCase();
        this.level = LogLevel[envLevel as keyof typeof LogLevel] ?? LogLevel.INFO;
        console.log(`[Logger] Nível ativo: ${LogLevel[this.level]} (${this.level})`);
    }

    isEnabled(level: LogLevel): boolean {
        return this.level >= level;
    }

    private format(level: string, message: string, context?: object): string {
        const timestamp = new Date().toISOString();
        const ctx = context ? ` ${JSON.stringify(context)}` : '';
        return `[${timestamp}] [${level}] ${message}${ctx}`;
    }

    error(message: string, context?: object) {
        if(!this.isEnabled(LogLevel.ERROR)) return;
        console.error(this.format(`ERROR: `, message, context));
    }

    debug(message: string, context?: object) {
        if(!this.isEnabled(LogLevel.DEBUG)) return;
        console.error(this.format(`DEBUG`, message, context));
    }

    info(message: string, context?: object) {
        if(!this.isEnabled(LogLevel.INFO)) return;
        console.error(this.format(`INFO`, message, context));
    }

    warn(message: string, context?: object) {
        if(!this.isEnabled(LogLevel.WARN)) return;
        console.error(this.format(`WARN`, message, context));
    }

    verbose(message: string, context?: object) {
        if(!this.isEnabled(LogLevel.VERBOSE)) return;
        console.error(this.format(`VERBOSE`, message, context));
    }
}