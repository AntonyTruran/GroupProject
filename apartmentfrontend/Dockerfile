FROM node:10
RUN npm install 
RUN npm run
RUN npm start
ENTRYPOINT ["/usr/local/bin/serve", "-l", "3000", "-s", "build"]