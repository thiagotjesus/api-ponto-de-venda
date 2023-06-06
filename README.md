# 💻 API RESTful: Ponto de venda

Este é um projeto feito em Java utilizando Spring Boot para criação de uma API RESTful com microserviços
___
## 📖 Objetivos do projeto:

<p>O projeto é um PDV onde teremos um microserviço para cadastro de produtos e um outro microserviço para realizar as vendas, este que será feito a comunicação síncrona para obter e atualizar as informações dos produtos. Cada serviço terá um banco de dados próprio utilizando o Postgree SQL. Onde iremos também fazer a relação entre as duas tabelas.</p>

<p>Fazemos a implementação do Service Discovery utilizando o Eureka (Solução desenvolvida pela Netflix), juntamente com uma API Gateway, que vai servir como ponto central para as nossas requisições.</p>

<p>Tratamos também os conceitos de circuit breaker e fallback, utilizando o Resilience4J e promovendo uma alternativa quando um dos serviços está inoperante.</p>


