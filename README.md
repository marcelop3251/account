# account
Projeto pessoal para gestão de usuários

#docker run commands

Start container from image mongoDB

docker run --name account-api -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=example -p 27017:27017 mongo

mongodb://root:example@localhost:27017/?ssl=false