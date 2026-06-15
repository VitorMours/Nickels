FROM node:20-alpine

WORKDIR /app

# Copiamos apenas os arquivos de dependência para instalar
COPY package*.json ./

# Instala todas as dependências (incluindo as de dev)
RUN npm install

# Copiamos o resto do código depois
COPY . .

# Expõe a porta
EXPOSE 3000

# O comando de watch do NestJS
CMD ["npm", "run", "start:dev"]