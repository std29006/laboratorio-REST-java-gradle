[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE) [![Build Status](https://travis-ci.org/std29006/laboratorio-REST-java-gradle.svg?branch=master)](https://travis-ci.org/std29006/laboratorio-REST-java-gradle)

# Laboratório com serviços web RESTful em Java

A API Java para RESTful Web Services (JAX-RS) faz uso de Anotações Java para o desenvolvimento de clientes e serviços REST. O Jersey é a implementação de referência para a especificação JSR 311 e JAX-RS provê suporte para criação de mensagens XML e JSON por meio do do JAXB. Na tabela abaixo são apresentadas algumas dessas anotações.

| Anotação | Descrição |
| -------------- | ---------------------------------- |
| @PATH(caminho) | Define o caminho base da aplicação |
| @PUT | Indica que o método abaixo da anotação irá responder pedidos HTTP PUT |
| @GET | Indica que o método abaixo da anotação irá responder pedidos HTTP GET |
| @POST | Indica que o método abaixo da anotação irá responder pedidos HTTP POST |
| @DELETE | Indica que o método abaixo da anotação irá responder pedidos HTTP DELETE |
| @Produces(MediaType. TEXT\_PLAIN[, outros tipos]) | Define o tipo MIME que será entregue por um método que tiver sido anotado com @GET. Outros exemplos: `application/xml`, `application/json` |
| @Consumes(type[, outros tipos]) | Define o tipo MIME que será consumido pelo método |
| @PathParam | Para obter valores de URL e inserir como parâmetro em um método |

## Primeiro exemplo

Um exemplo simples que tem por objetivo mostrar como mapear os verbos GET, POST, PUT e DELETE.

### Consumindo o serviço com o curl

```shell
curl http://localhost:8080/api/v1/exemplo

curl http://localhost:8080/api/v1/exemplo/fulano

curl http://localhost:8080/api/v1/exemplo/pessoas

curl -X POST http://localhost:8080/api/v1/exemplo/pessoas -H "Content-Type: application/json" -d '{"nome": "Juca", "email":"novo@email.com"}'

curl -X PUT http://localhost:8080/api/v1/exemplo/pessoas -H "Content-Type: application/json"  -d '{"nome": "Juca", "email":"novo@email.com"}'

curl -X DELETE http://localhost:8080/api/v1/exemplo/pessoas/fulano 
```

## Serviço para gestão de laboratórios

Exemplo de um serviço para gestão dos laboratórios de ensino dos campi do IFSC. É criada uma base de dados em memória para armazenar os dados dos campi.

[Essa API foi documentada](https://laboratorios.docs.apiary.io) de acordo com a especificação API Blueprint e a mesma pode ser visualizada com o [Apiary](https://apiary.io/). O código fonte dessa documentação também está disponível no arquivo [apiary.apib](apiary.apib) nesse repositório.
