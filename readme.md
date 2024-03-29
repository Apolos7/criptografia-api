# Criptografia API

API criada para experimentar o uso de criptografia para proteção de dados sensíveis utilizando a biblioteca Jasypt. Além
do uso da criptografia, foi utilizada a biblioteca Hibernate Envers para realizar a auditoria da tabela de operações,
sem comprometer os dados sensíveis mesmo que criptografados.

## Lista de tarefas realizadas

    ✅ Criptografia dos dados sensíveis;
    ✅ Descriptografia dos dados sensíveis;
    ✅ Endpoints CRUD para as operações;
    🔳 Endpoints de visualização das revisões geradas pelo Hibernate Envers das operações.

## 📚 Bibliotecas utilizadas

- Spring Web
- Spring Data JPA
- Flyway
- Hibernate Envers
- PostgreSQL Driver
- Jasypt
- Swagger

## 🌱 Swagger

O Swagger é uma ferramenta que permite projetar, construir, documentar e consumir serviços Web RESTful. Aqui usaremos
ele para exibir os endpoints da nossa API e consumi-los. O endereço do Swagger após a execução do projeto
será [http://localhost:8080/api/docs-ui](http://localhost:8080/api/docs-ui).

## 🛑 Requisitos para executar a aplicação

### Executar na sua IDE

- ✅ Java JDK LTS 21
- ✅ IDE (Visual Studio Code, Eclipse, IntelliJ, Spring Tool Suite)
- ✅ Postman/Insomnia (Ferramentas para realizar testes na API)

### 🐋 Docker Compose

Necessário ter o Docker e Docker Compose instalados na sua máquina, os links para download em cada plataforma podem ser
encontrados em [Docker](https://docs.docker.com/get-docker/)
e [Docker Compose](https://docs.docker.com/compose/install/).

Para parar a execução da API, basta executar `docker compose down`

#### 🐧 Linux

Com o Docker e Docker Compose instalados, basta executar o script `build-and-run-docker-compose.sh`.

- Com o terminal aberto na raiz do projeto, execute: `chmod +x ./build-and-run-docker-compose.sh`
- Então, por fim, execute o script: `./build-and-run-docker-compose.sh`
- Se tudo der certo, você deve conseguir acessar o
  endereço: [http://localhost:8080/api/docs-ui](http://localhost:8080/api/docs-ui)

#### 🪟 Windows

Com o Docker e Docker Compose instalados:

- Com o terminal aberto na raiz do projeto, execute para buildar o projeto: `./gradlew clean build`
- Faça o build da imagem do Docker: `docker build -f criptografia -f Dockerfile .`
- Então, por fim, execute via Docker Compose: `docker compose up -d`