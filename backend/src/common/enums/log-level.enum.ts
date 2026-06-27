export enum LogLevel {
  NONE    = 0,  // não loga nada
  ERROR   = 1,  // só erros
  WARN    = 2,  // erros + avisos
  INFO    = 3,  // + método, rota, status, tempo
  DEBUG   = 4,  // + headers e body
  VERBOSE = 5,  // + tudo, inclusive response body
}