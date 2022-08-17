<p align="center">
        <img src="https://avatars.githubusercontent.com/u/109238400?s=400&u=e5b242311297e5a0b1c2a7e4efd42d523c158b59&v=4">
</p>

## Sobre

O FreshWarehouse é uma aplicação feita para ajudar a administrar um estoque de produtos frescos em um Marketplace. Consultando sua API é possivel passar por todo o processo desde quando um vendedor cadastra um produto, até ele ser adicionado em um lote, enviado para um armazem, até ser adicionado em um carrinho de compras por um usuário.

Foi desenvolvida uma feature para gerenciamento das camaras frias do depósito. É possível criar, listar todas, obter por id, atualizar dados, ativar ou desativar, registar vistoria e alterar temperatura das camaras frias, via endpoints implementados.

User Story pode ser encontrada em: https://github.com/ALyssaccs/freshWarehouse-Angelica/blob/develop/Documents/Cold%20Room%20Management.pdf

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando o framework [Spring](https://spring.io/projects/spring-boot) escrito em [Java](https://www.java.com/pt-BR/) e os testes foram feitos utilizando o [JUnit](https://junit.org/junit5/). A API funciona por meio de requisições HTTP, e como meta futura, o deploy seria feito por meio do Fury. A gerencia de dependências é feita pelo [Maven](https://maven.apache.org/).

## Documentação

Documentação da API foi feita em JavaDoc, assim como as collections do postman para fazerem as requisições podem ser encontradas em: [Documentos](https://github.com/javatastico/freshWarehouse/tree/develop/Documents).
Também está disponível documentação em Swagger, que pode ser encontrada em: 
(http://localhost:8080/swagger-ui/index.html).


## UML

<p align="center">
  <img src="https://github.com/ALyssaccs/freshWarehouse-Angelica/blob/develop/Documents/freshWarehouse-entities.png?raw=true">
</p>

## Licença

Este projeto está licenciado sob os termos da [licença MIT](https://github.com/javatastico/freshWarehouse/blob/develop/LICENSE).

Copyright (c) 2022 Javatastico
