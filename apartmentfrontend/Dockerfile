FROM node:latest
RUN npm install
RUN npm update
RUN npm start
ENTRYPOINT ["/usr/local/bin/serve", "-l", "3000", "-s", "build"]