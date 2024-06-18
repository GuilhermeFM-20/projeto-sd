# A3 Sistemas Distribuídos e Mobile - Atlas FIT

Este projeto visa implementar um serviço RESTful para o aplicativo do Atlas Fit. Será utilizado o Spring Boot na versão 3.2.5 com o Java na versão 17. Também será utilizado o Swagger para documentar as rotas dos serviços da API. O projeto é uma API que faz o controle das informações sobre os exercícios, refeições e controle de peso.

## Tecnologias Usadas

- Swagger
- Spring Boot
- Maven
- MySQL

## Instalação do Projeto

1. Após clonar o projeto, será necessário rodar o comando `mvn clean install -DskipTests` dentro do diretório `/demo`.

   Observação: Verificar se o Maven está instalado, caso contrário, será necessário rodar os comandos `sudo apt update` e depois o comando `sudo apt install maven` para instalar o Maven.

2. Após a instalação correta do Maven e das dependências do Spring Boot, é só rodar o comando `mvn spring-boot:run` para iniciar o projeto.

## Rota da API

O projeto possui a documentação da API com Swagger.

- Para consultar a documentação, é só acessar a rota `GET /swagger-ui/index.html` quando o projeto estiver rodando.
