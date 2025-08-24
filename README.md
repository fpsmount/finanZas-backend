# FinanZas Backend (API)

Este é o backend da aplicação de gerenciamento financeiro "FinanZas". Construído com Spring Boot, ele fornece uma API REST para gerenciar as entradas e saídas de dados, que são persistidos em um banco de dados PostgreSQL.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.5**: Framework para construção da aplicação.
- **Spring Data JPA**: Para a camada de persistência e comunicação com o banco de dados.
- **PostgreSQL**: Banco de dados relacional para armazenar os dados da aplicação.
- **Lombok**: Para reduzir o código boilerplate nas classes de modelo (getters, setters, etc.).
- **Maven**: Gerenciador de dependências.

## 🚀 Endpoints da API

A API expõe os seguintes endpoints REST para gerenciar os dados de entradas e saídas:

### Entradas
- `GET /api/entradas`: Lista todas as entradas.
- `GET /api/entradas/{id}`: Busca uma entrada por ID.
- `POST /api/entradas`: Adiciona uma nova entrada.
- `PUT /api/entradas/{id}`: Atualiza uma entrada existente.
- `DELETE /api/entradas/{id}`: Exclui uma entrada por ID.

### Saídas
- `GET /api/saidas`: Lista todas as saídas.
- `GET /api/saidas/{id}`: Busca uma saída por ID.
- `POST /api/saidas`: Adiciona uma nova saída.
- `PUT /api/saidas/{id}`: Atualiza uma saída existente.
- `DELETE /api/saidas/{id}`: Exclui uma saída por ID.

## ⚙️ Configuração do Projeto

### Pré-requisitos
Certifique-se de ter o **JDK 17** e o **PostgreSQL** instalados em sua máquina.

### Banco de Dados
O backend está configurado para se conectar a um banco de dados PostgreSQL. As tabelas serão criadas automaticamente pelo Hibernate ao iniciar a aplicação.

1.  **Crie o banco de dados:**
    ```bash
    psql -U postgres
    CREATE DATABASE finanzas;
    \q
    ```

2.  **Ajuste as credenciais:**
    Verifique se as credenciais no arquivo `src/main/resources/application.properties` estão corretas:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/finanzas
    spring.datasource.username=postgres
    spring.datasource.password=123456
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
    *Substitua `postgres` e `123456` pelas suas credenciais, se necessário.*

### CORS
A aplicação está configurada para permitir requisições do frontend em `http://localhost:3000`. Essa configuração está no arquivo `CorsConfig.java` e garante que as comunicações entre frontend e backend não sejam bloqueadas pelo navegador.

## ▶️ Como Executar a Aplicação

1.  **Navegue até o diretório raiz do backend.**
2.  **Inicie a aplicação Spring Boot:**
    ```bash
    ./mvnw spring-boot:run
    ```
    A aplicação será iniciada na porta `8080`.

Você pode testar os endpoints usando ferramentas como o Insomnia ou Postman antes de se conectar com o frontend.
