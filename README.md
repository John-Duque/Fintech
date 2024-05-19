# Fintech

Este projeto é um serviço backend desenvolvido em Spring Boot para coletar informações de crédito de usuários interessados em solicitar um empréstimo. O serviço aceita solicitações via API, valida os dados fornecidos e armazena essas informações em um banco de dados MySQL.

---

## Tecnologias Utilizadas

- Java
- Spring Boot
- MySQL
- Docker e Docker Compose
- Hibernate Validator (Bean Validation)
- Flyway
- Lombok
- Maven

---

## Configuração e Execução

### Pré-requisitos

- Docker
- Docker Compose

---

### Passos para Configuração

1. **Clone o repositório**:
   ```sh
   git clone https://github.com/John-Duque/fintech.git
   cd fintech
   ```

2. **Baixe as imagens necessárias**:
    ```sh
   docker pull maven:3.8.5-openjdk-17
   docker pull openjdk:17-jdk-slim
   docker pull mysql:8.0
   ```
   
3. **Compile e inicie a aplicação com Docker Compose**:
    ```sh
    docker-compose up --build
   
---

### Execução

1. Após a configuração, você pode acessar o aplicativo em [http://localhost:8080/api/credits](http://localhost:8080/api/credits).

   Para empréstimo, envie uma solicitação POST para o endpoint `/api/credits` com um JSON no seguinte formato:

    ```json
    {
        "name": "seuNome",
        "loanAmount": 1000,
        "monthlyIncome": 3000
    }
    ```

   Isso demonstra um exemplo de solicitação com o nome,valor do empréstimo desejado e a renda mensal declarada.

   Você pode usar ferramentas como cURL, Postman ou Insomnia para enviar a solicitação para o aplicativo.

    ```sh
    curl -X POST -H "Content-Type: application/json" -d '{
        "name": "seuNome",
        "loanAmount": 1000,
        "monthlyIncome": 3000
    }' http://localhost:8080/api/credits
    ```

   Isso enviará a solicitação de informações de crédito para o aplicativo em execução localmente.

Lembre-se de adaptar os valores de "name", "loanAmount" e "monthlyIncome" conforme necessário para refletir os dados de solicitação reais.

---
