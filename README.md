# FOOD SYSTEM

Projeto FIAP
Software Architecture / Turma 6

- Eduardo Silva - RM352655 
- Edvan Jeronimo - RM353253
- Felipe Ghidini - RM353787
- Fernanda Vidal - RM353413
- Halisson Brancalhão - RM354155

Event Storming
[Miro - Event Storming](https://miro.com/welcomeonboard/NG11bWxGbHJNSmhSNTZoTmRFb3FmNlRwZ1VZM25VbEgySXhoYzZUNVVwbnF2ZWRqbEVjSHFueWMzRE80eWdlYnwzMDc0NDU3MzYyMjUwOTY4MTQ5fDI=?share_link_id=573870846258)


Documentação Swagger
http://localhost:8080/documentation.html


## Instuições para subir o sistema local
Criar o jar do sistema (Quando baixar o repositório ou para gerar nova imagem docker):
```sh
mvn clean install  
```
Fazer a build da imagem
```sh
docker build -t food-system .
```
Subir container (Profile default - Banco de dados em memória H2)
```sh
docker run -d --name food-system -p 8080:8080 food-system
```
Subir docker-compose (Profile deploy - Banco de dados Postgress)
```sh
docker-compose up -d
```