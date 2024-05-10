# foodsystem



#Criar o jar do sistema ( quando fizer alterações )

mvn clean install  

#Fazer a build da imagem

docker build -t food-system .

#Subir container

docker run -d --name food-system -p 8080:8080 food-system
