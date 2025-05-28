FROM node:22.15.1-slim

WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install --include prod

COPY ./dist dist

EXPOSE 3000

CMD ["node", "dist/main"]