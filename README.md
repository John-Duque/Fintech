# Fintech

Este projeto é um serviço backend desenvolvido em Spring Boot para coletar informações de crédito de usuários
interessados em solicitar um empréstimo. O serviço aceita solicitações via API, valida os dados fornecidos e armazena
essas informações em um banco de dados MySQL.

---

## Índice

1. [Tecnologias Utilizadas](#tecnologias-utilizadas)
2. [Configuração e Execução](#configuração-e-execução)
    1. [Pré-requisitos](#pré-requisitos)
    2. [Passos para Configuração](#passos-para-configuração)
3. [Execução](#execução)
4. [Usando o Swagger](#usando-o-swagger)
5. [Acessando o Banco de Dados MySQL via Docker](#acessando-o-banco-de-dados-mysql-via-docker)

---

## Tecnologias Utilizadas

- Java(v17)
- Spring Boot(v3.2.5)
- MySQL(v8.0)
- Docker e Docker Compose(v26.0.0)
- Hibernate Validator (Bean Validation)
- Flyway
- Lombok
- Maven
- swagger(v2.5.0)

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
   ```

   ```sh
   cd fintech
   ```

2. **Baixe as imagens necessárias**:
    ```sh
   docker pull maven:3.8.5-openjdk-17
   ```

    ```sh
   docker pull openjdk:17-jdk-slim
   ```

    ```sh
   docker pull mysql:8.0
   ```

3. **Compile e inicie a aplicação com Docker Compose**:
    ```sh
    docker-compose up --build
   ```

---

### Execução

1. Após a configuração, você pode acessar o aplicativo
   em [http://localhost:8080/api/credits](http://localhost:8080/api/credits).

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

---

### Usando o Swagger

O Swagger fornece uma interface gráfica para interagir com a API sem a necessidade de outras ferramentas como cURL ou
Postman. Aqui estão os passos para usar o Swagger:

1. **Acesse a interface do Swagger**:

- Abra o navegador e vá para [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

2. **Explore os Endpoints**:

- A interface do Swagger exibirá todos os endpoints disponíveis na API, juntamente com as descrições e exemplos de uso.

3. **Teste os Endpoints**:

- Clique em um endpoint para expandi-lo. Você verá opções para testar diferentes tipos de solicitações (GET, POST,
  etc.).

- Para um endpoint POST, como /api/credits, clique em "Try it out".

- Insira os dados necessários no formato JSON fornecido:

    ```json
    {
        "name": "seuNome",
        "loanAmount": 1000,
        "monthlyIncome": 3000
    }
    ```

- Clique em "Execute" para enviar a solicitação. A resposta do servidor será exibida abaixo, incluindo o código de
  status HTTP e qualquer dado retornado.

4. **Visualize a Documentação**:

- O Swagger também gera documentação automática para a API, incluindo descrições de parâmetros, esquemas de resposta e
  possíveis códigos de erro.

Usando o Swagger, você pode facilmente testar e entender a funcionalidade da API sem precisar escrever código
manualmente para cada solicitação.

Lembre-se de adaptar os valores de "name", "loanAmount" e "monthlyIncome" conforme necessário para refletir os dados de
solicitação reais.

---

### Acessando o Banco de Dados MySQL via Docker

Para acessar o banco de dados MySQL que está sendo executado em um contêiner Docker, você pode seguir os passos abaixo:

1. **identifique o nome ou ID do contêiner MySQL**:

   ```sh
   docker ps
   ```

   Localize o contêiner MySQL na lista e anote o nome ou ID do contêiner.

2. **Acesse o contêiner MySQL**:

   ```sh
   docker exec -it <container_name_or_id> mysql -u root -p
   ```
   Substitua <container_name_or_id> pelo nome ou ID do contêiner que você anotou. Será solicitado que você insira a
   senha do usuário root do MySQL. **Não se esqueça de passar a senha da base de dados ao utilizar o parâmetro -p**.

3. **Interaja com o banco de dados**:

- Uma vez conectado, você pode executar comandos SQL para interagir com o banco de dados. Por exemplo, para listar todas as bases de dados:

   ```sh
   SHOW DATABASES;
   ```
  
- Para usar uma base de dados específica:

   ```sh
   USE nome_da_base_de_dados;
   ```
  
- Para listar todas as tabelas dentro da base de dados selecionada:

   ```sh
   SHOW TABLES;
   ```
  
- Para visualizar os dados de uma tabela específica:

   ```sh
   SELECT * FROM nome_da_tabela;
   ```

Seguindo esses passos, você poderá acessar e gerenciar o banco de dados MySQL diretamente do contêiner Docker.