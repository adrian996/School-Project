# FROM node:16-alpine as node

# RUN mkdir -p /app

# WORKDIR /app

# COPY . .

# RUN npm install
# RUN npm run build

# CMD ["npm", "start"]



#stage 1
FROM node:16-alpine as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build
#stage 2
FROM nginx:stable-alpine
COPY --from=node /app/dist/mylittleproject-front /usr/share/nginx/html
