# FOOD SYSTEM

Projeto FIAP
Software Architecture / Turma 6

- Eduardo Silva - RM352655 (Discord: Eduardo Silva - 6SOAT / RM352655)
- Edvan Jeronimo - RM353253 (Discord: Edvan Jeronimo - RM353253)
- Felipe Ghidini - RM353787 (Discord: Felipe Ghidini - 6SOAT-RM353787)
- Fernanda Vidal - RM353413 (Discord: Fernanda Vidal - RM 353413)
- Halisson Brancalhão - RM354155 (Discord: Hallison Brancalhão - RM354155)

Event Storming
[Miro - Event Storming](https://miro.com/app/board/uXjVKPwP9b0=/?share_link_id=965497713343)


Documentação Swagger
http://localhost:8080/documentation.html


## Subir aplicação com Docker-Compose
Profile deploy - Banco de dados Postgres
```sh
docker-compose up -d
```


## Instruções para subir o sistema local - desenvolvimento
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
