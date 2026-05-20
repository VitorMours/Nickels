# ---------- Build stage ----------
FROM node:20-alpine AS builder

WORKDIR /app

# Copia package files primeiro para aproveitar cache
COPY package*.json ./

# Instala TODAS as dependências
RUN npm ci

# Copia restante da aplicação
COPY . .

# Build do NestJS
RUN npm run build

# ---------- Production stage ----------
FROM node:20-alpine AS production

WORKDIR /app

ENV NODE_ENV=production

# Copia apenas package files
COPY package*.json ./

# Instala apenas deps de produção
RUN npm ci --omit=dev

# Copia build gerado
COPY --from=builder /app/dist ./dist

# Expõe porta
EXPOSE 3000

# Usuário não-root
USER node

# Inicializa aplicação
CMD ["node", "dist/main"]