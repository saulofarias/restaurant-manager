# Restaurant Manager API 

## Api Rest para cadastro e consulta de clientes.

### Requitos

- Java 11
- Spring Boot
- PostgresSQL
- Docker

### Funcionamento

A API deve cadastrar pedidos de um restaurante e realizar operações básicas de um CRUD.

### Operações suportadas

- Realizar Login
- Cadastrar Pedido
- Listar Pedido
- Editar Pedido
- Finalizar Pedido

### Endpoints

#### Auth

- POST /register

    - Realizamos um cadastro de usuário para podermos acessar o sistema, devemos informa o nome, email e senha conforme exemplo.
    - A resposta deve conter os seguintes códigos:

      - 200: em caso de sucesso
      - 500: em caso de falha

_Exemplo: uri/register

_request:_

```json
{
	"name": "Teste",
	"email" : "teste@gmail.com.br",
	"password" : "1234"	
}
```

_response:_

```json
{
	"name": "Teste",
	"email" : "teste@gmail.com.br",
	"password" : "1234"	
}
```

- POST /authenticate

    - Informamos um email e senha previamente cadastrados para recebermos um token.
    - Retorna um jwt-token para ser usado nas demais requisições realizadas.
    - A resposta deve conter os seguintes códigos:

      - 200: em caso de sucesso
      - 401: em caso de falha

_Exemplo: uri/authenticate_

_request:_

```json
{
	"username" : "teste@gmail.com",
	"password" : "1234"
}
```

_response:_

```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYXVsb2Zhcmlhc2xpdmVAZ21haWwuY29tIiwiZXhwIjoxNjA1MzE1MDY1LCJpYXQiOjE2MDUyOTcwNjV9.h7NWHegURC0zIfIp9cZIMeSTtSQSQk0RWu0_AmnK1f7TEzSqdtrc5uGxsoGGxBcbBNig81F08VZ6_KkMgoFXUQ"
}
```

## Testes

## Execução

Por padrão, a API está disponível em [http: // localhost: 8080 /] (http: // localhost: 8080 /)

Para executar a API, podemos usar os seguintes métodos:

_cd target && java -jar customer-server-0.0.1-SNAPSHOT.jar_

ou com o seguinte comando

_mvn spring-boot: run_

## Docker

A API está configurada para ser usada com o Docker, para tal devemos seguir os seguintes passos:

* Primeiro devemos construir o executável de nossa aplicação com o seguinte comando: _mvn clean package_

* Devemos rodar o seguinte comando: _docker-compose up --build_

Se tudo ocorrer bem podemos acessar os recursos da API normalmente como mostrado no tópico Endpoints.
```
