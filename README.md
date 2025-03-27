#  Posts API

API RESTful desenvolvida em **Java** com **Spring Boot**, utilizando **MongoDB** como banco de dados e gerenciada com **Maven**.  
Ela permite o gerenciamento de usuários, posts e comentários de forma simples e eficiente.

----------

##  Tecnologias utilizadas

-   Java 17+
    
-   Spring Boot
    
-   Spring Data MongoDB
    
-   Maven
    
-   MongoDB
    
-   Insomnia (para testes)
    

----------

##  Modelo de Domínio

![Modelo de Domínio](./src/main/resources/static/domain.png)

----------

##  Endpoints disponíveis

Método

Rota

Descrição

GET

`/users`

Lista todos os usuários

GET

`/posts`

Lista todos os posts

POST

`/posts`

Cria um novo post

POST

`/posts/:id/comment`

Adiciona um comentário a um post

PUT

`/posts/:id/comment/index`

Atualiza um comentário específico

DELETE

`/posts/{id}/comment/{index}/author/{userId}`

Deleta um comentário do autor especificado

PUT

`/posts/:id`

Atualiza um post

DELETE

`/posts`

Remove todos os posts

POST

`/users`

Cria um novo usuário

PUT

`/users`

Atualiza os dados de um usuário

DELETE

`/users/{id}`

Remove um usuário

----------

##  Como rodar o projeto localmente

```bash
# Clone o repositório
git clone git@github.com:JuniorPaula/post-api-java.git

# Acesse o diretório
cd posts-api

# Execute a aplicação
./mvnw spring-boot:run

```

Certifique-se de que o MongoDB esteja rodando localmente na porta padrão (`27017`).

----------
