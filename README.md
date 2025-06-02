
# MaracaEduca - Sistema de Mapeamento de Escolas Públicas de Maracanaú - Backend

-----

[](https://opensource.org/licenses/MIT)
[](https://www.java.com/)
[](https://spring.io/projects/spring-boot)
[](https://www.postgresql.org/)
[](https://www.google.com/search?q=https://github.com/seu-usuario/seu-repositorio)

Este repositório contém o código-fonte do **backend** do sistema de mapeamento de escolas públicas do município de Maracanaú. Desenvolvido com uma arquitetura de **microsserviços**, o projeto visa oferecer uma solução robusta, escalável e de fácil manutenção para gerenciar informações sobre escolas, autenticar usuários, e futuramente, exibir dados geolocalizados e gerar relatórios.

-----

## 📚 Sumário

  * [Visão Geral da Arquitetura](https://www.google.com/search?q=%23-vis%C3%A3o-geral-da-arquitetura)
  * [Tecnologias Utilizadas](https://www.google.com/search?q=%23-tecnologias-utilizadas)
  * [Microsserviços Implementados](https://www.google.com/search?q=%23-microsservi%C3%A7os-implementados)
      * [Serviço de Autenticação (`auth-service`)](https://www.google.com/search?q=%23servi%C3%A7o-de-autentica%C3%A7%C3%A3o-auth-service)
      * [Serviço de Dados das Escolas (`schools-data-service`)](https://www.google.com/search?q=%23servi%C3%A7o-de-dados-das-escolas-schools-data-service)
  * [Microsserviços Futuros](https://www.google.com/search?q=%23-microsservi%C3%A7os-futuros)
  * [Pré-requisitos](https://www.google.com/search?q=%23-pr%C3%A9-requisitos)
  * [Configuração do Banco de Dados PostgreSQL](https://www.google.com/search?q=%23-configura%C3%A7%C3%A3o-do-banco-de-dados-postgresql)
  * [Como Rodar os Serviços](https://www.google.com/search?q=%23-como-rodar-os-servi%C3%A7os)
  * [Testando as APIs](https://www.google.com/search?q=%23-testando-as-apis)
  * [Considerações de Desenvolvimento e Implantação](https://www.google.com/search?q=%23-considera%C3%A7%C3%B5es-de-desenvolvimento-e-implanta%C3%A7%C3%A3o)
  * [Contribuição](https://www.google.com/search?q=%23-contribui%C3%A7%C3%A3o)
  * [Licença](https://www.google.com/search?q=%23-licen%C3%A7a)

-----

## 🏗️ Visão Geral da Arquitetura

O backend é construído sobre uma arquitetura de **microsserviços**, onde cada funcionalidade é encapsulada em um serviço independente. Isso permite um desenvolvimento mais ágil, implantação isolada, e maior resiliência em caso de falhas.

-----

## 💻 Tecnologias Utilizadas

  * **Linguagem:** Java 17+
  * **Frameworks:**
      * **Spring Boot:** Para rápida criação de aplicações Java.
      * **Spring Data JPA:** Para interação com o banco de dados.
      * **Spring Security:** Para segurança e autenticação.
      * **Lombok:** Para reduzir o *boilerplate* de código.
  * **Banco de Dados:** PostgreSQL
  * **Segurança:** JWT (JSON Web Tokens)
  * **Build Tool:** Apache Maven

-----

## 📦 Microsserviços Implementados

A estrutura do projeto no GitHub será organizada em diretórios para cada microsserviço:

```
.
├── auth-service/
├── schools-data-service/
├── .gitignore
├── pom.xml
└── README.md
```

### Serviço de Autenticação (`auth-service`)

Responsável por gerenciar o **registro de novos usuários**, o **login** e a **geração e validação de JWTs** (JSON Web Tokens) para controle de acesso.

  * **Tecnologia:** Spring Boot, Spring Security, JWT, Spring Data JPA
  * **Banco de Dados:** PostgreSQL (`maracanau_auth_db`)
  * **Porta Padrão:** `8082`
  * **Endpoints Principais:**
      * `POST /api/auth/register`: Registrar um novo usuário.
      * `POST /api/auth/login`: Autenticar um usuário e obter um JWT.

### Serviço de Dados das Escolas (`schools-data-service`)

Gerencia as **informações detalhadas das escolas públicas** do município, permitindo operações de **CRUD** (Criar, Ler, Atualizar, Deletar).

  * **Tecnologia:** Spring Boot, Spring Data JPA
  * **Banco de Dados:** PostgreSQL (`maracanau_schools_db`)
  * **Porta Padrão:** `8081`
  * **Endpoints Principais:**
      * `GET /api/schools`: Listar todas as escolas.
      * `GET /api/schools/{id}`: Obter detalhes de uma escola específica.
      * `POST /api/schools`: Adicionar uma nova escola.
      * `PUT /api/schools/{id}`: Atualizar informações de uma escola.
      * `DELETE /api/schools/{id}`: Remover uma escola.

-----

## 🚀 Microsserviços Futuros

Os seguintes serviços estão planejados e serão desenvolvidos em fases posteriores para expandir as funcionalidades do sistema:

  * **Serviço de Geolocalização:**
      * **Função:** Localizar e exibir escolas no mapa utilizando APIs de geolocalização (Google Maps/OpenStreetMap).
      * **Endpoint:** `/api/geolocation`
  * **Serviço de Relatórios:**
      * **Função:** Gerar relatórios analíticos e visualizações de dados sobre as escolas (integrado com ferramentas de visualização no frontend, como Chart.js).
      * **Endpoint:** `/api/reports`
  * **Serviço de Feedback:**
      * **Função:** Receber feedback dos usuários sobre as escolas de forma assíncrona, utilizando um sistema de filas (ex: RabbitMQ).
      * **Endpoint:** `/api/feedback`

-----

## 📋 Pré-requisitos

Para rodar este backend localmente, você precisará ter instalado:

  * **Java Development Kit (JDK) 17+:** [Baixar JDK](https://www.oracle.com/java/technologies/downloads/)
  * **Apache Maven 3.6.3+:** [Baixar Maven](https://maven.apache.org/download.cgi)
  * **PostgreSQL:** [Baixar PostgreSQL](https://www.postgresql.org/download/)
      * Certifique-se de que o servidor PostgreSQL esteja em execução.
  * **Git:** Para clonar o repositório.
  * **Postman / Insomnia (Opcional):** Para testar as APIs facilmente.

-----

## ⚙️ Configuração do Banco de Dados PostgreSQL

1.  Certifique-se de que sua instância do **PostgreSQL esteja rodando**.

2.  Crie os dois bancos de dados necessários para os microsserviços:

      * `maracanau_auth_db`
      * `maracanau_schools_db`

    Você pode fazer isso via terminal `psql` ou uma ferramenta GUI como PgAdmin:

    ```sql
    CREATE DATABASE maracanau_auth_db;
    CREATE DATABASE maracanau_schools_db;
    ```

3.  Para cada microsserviço (dentro de `auth-service/` e `schools-data-service/`), edite o arquivo `src/main/resources/application.properties` e configure as credenciais do seu banco de dados:

    ```properties
    # Exemplo para auth-service (adapte para schools-data-service com o nome do DB correto)
    spring.datasource.url=jdbc:postgresql://localhost:5432/maracanau_auth_db
    spring.datasource.username=seu_usuario_postgresql
    spring.datasource.password=sua_senha_postgresql
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update # 'update' cria/atualiza tabelas automaticamente
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.show-sql=true # Útil para debug
    ```

    **Lembre-se de substituir `seu_usuario_postgresql` e `sua_senha_postgresql` pelas suas credenciais.**

4.  Para o `auth-service`, adicione (ou atualize) também a chave secreta JWT no `application.properties`:

    ```properties
    jwt.secret=UMA_CHAVE_SECRETA_LONGA_E_ALEATORIA_PARA_MAIOR_SEGURANCA_DO_JWT
    ```

    **É crucial que esta chave seja forte e não compartilhada.**

-----

## ▶️ Como Rodar os Serviços

Cada microsserviço é uma aplicação Spring Boot independente e deve ser executado separadamente.

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    cd seu-repositorio/backend
    ```

    **(Lembre-se de substituir `seu-usuario/seu-repositorio` pelo caminho real do seu projeto no GitHub.)**

2.  **Para cada microsserviço (repita os passos para `auth-service` e `schools-data-service`):**

    a.  **Navegue até o diretório do serviço:**
    ` bash cd auth-service/ # ou schools-data-service/  `

    b.  **Compile e empacote o projeto com Maven:**
    ` bash mvn clean install  `

    c.  **Execute a aplicação Spring Boot:**
    ` bash mvn spring-boot:run  `
    Opcionalmente, você pode executar o JAR gerado na pasta `target/`:
    ` bash java -jar target/*.jar # Substitua * pelo nome exato do seu JAR  `

    Após iniciar, você verá logs no console indicando que a aplicação está rodando na porta configurada (ex: `Started Application in X seconds (JVM running for Y)`).

-----

## 🧪 Testando as APIs

Com os serviços rodando, você pode usar **Postman** ou **Insomnia** para interagir com as APIs:

### Teste do `auth-service` (porta 8082)

1.  **Registrar um Usuário:**
      * **URL:** `POST http://localhost:8082/api/auth/register`
      * **Headers:** `Content-Type: application/json`
      * **Body (raw JSON):**
        ```json
        {
            "username": "testuser",
            "password": "password123"
        }
        ```
2.  **Login e Obtenção do JWT:**
      * **URL:** `POST http://localhost:8082/api/auth/login`
      * **Headers:** `Content-Type: application/json`
      * **Body (raw JSON):**
        ```json
        {
            "username": "testuser",
            "password": "password123"
        }
        ```
      * **Resposta:** Você receberá um JSON com o campo `token` contendo seu JWT. Copie este token.

### Teste do `schools-data-service` (porta 8081)

1.  **Criar uma Escola (exemplo):**
      * **URL:** `POST http://localhost:8081/api/schools`
      * **Headers:** `Content-Type: application/json`
          * **Importante:** Se você decidir proteger este *endpoint* com JWT no futuro, adicione:
            `Authorization: Bearer SEU_TOKEN_JWT_AQUI`
      * **Body (raw JSON):**
        ```json
        {
            "name": "Escola Municipal Professor João Alves",
            "address": "Rua das Flores, 456",
            "district": "Centro",
            "phone": "(85) 3212-3456",
            "email": "contato@escola.com",
            "latitude": -3.8756,
            "longitude": -38.6234,
            "principalName": "Maria da Silva",
            "numberOfStudents": 500
        }
        ```
2.  **Listar Todas as Escolas:**
      * **URL:** `GET http://localhost:8081/api/schools`

-----

## 💡 Considerações de Desenvolvimento e Implantação

  * **Isolamento:** Cada microsserviço é um processo independente. Eles devem ser executados em portas separadas e, idealmente, em ambientes de contêineres distintos.
  * **Dockerização:** Para facilitar a implantação e garantir consistência entre ambientes, é altamente recomendado **dockerizar** cada microsserviço. Isso envolve a criação de um `Dockerfile` para cada um.
  * **Orquestração:** Para gerenciar e escalar os múltiplos contêineres, ferramentas como **Docker Compose** (para ambientes de desenvolvimento e testes) e **Kubernetes** (para produção) serão cruciais.
  * **Documentação da API:** A integração com **Springdoc OpenAPI (Swagger UI)** em cada serviço pode fornecer uma documentação interativa e automatizada dos *endpoints* da API, facilitando o consumo por outras equipes (e.g., *frontend*).

-----

## 🤝 Contribuição

Ficou interessado em contribuir? Sinta-se à vontade para:

1.  Fazer um **fork** deste repositório.
2.  Criar uma nova `branch` para sua funcionalidade (`git checkout -b feature/minha-nova-feature`).
3.  Implementar suas mudanças.
4.  Realizar os *commits* (`git commit -m 'feat: adiciona nova feature'`).
5.  Enviar para sua `branch` (`git push origin feature/minha-nova-feature`).
6.  Abrir um **Pull Request**.

-----

## 📄 Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](https://www.google.com/search?q=LICENSE) para mais detalhes.

-----

Espero que agora o README esteja exatamente como você imaginou para o GitHub\! Se precisar de mais alguma coisa ou tiver novas ideias, é só me dizer.
