# Springboot Webservices API

API REST desenvolvida com Spring Boot, com autenticação JWT, gerenciamento de usuários, produtos, categorias e pedidos.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-green?style=flat-square&logo=spring)
![H2](https://img.shields.io/badge/H2-Database-blue?style=flat-square)
![JWT](https://img.shields.io/badge/JWT-Auth-black?style=flat-square&logo=jsonwebtokens)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?style=flat-square&logo=swagger)

## Sobre o projeto

API REST completa com autenticação stateless via JWT, cobrindo as operações CRUD de um sistema de e-commerce simplificado. O projeto segue boas práticas de desenvolvimento como injeção de dependência por construtor, separação por camadas, DTOs para controle de entrada/saída e tratamento global de exceções.

## Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Security** — autenticação e autorização
- **JWT (JJWT 0.11.5)** — tokens stateless
- **Spring Data JPA + Hibernate** — persistência de dados
- **H2 Database** — banco em memória para desenvolvimento e testes
- **Springdoc OpenAPI (Swagger UI)** — documentação interativa
- **Bean Validation** — validação de dados de entrada

## Arquitetura

```
src/
├── auth/               # Autenticação (login, LoginRequest)
├── config/             # Configurações (JWT, Security, Swagger)
├── dto/                # Objetos de transferência de dados
├── entities/           # Entidades JPA
│   ├── enums/          # Enumerações (OrderStatus)
│   └── pk/             # Chaves compostas
├── repositories/       # Interfaces JPA Repository
├── resources/          # Controllers REST
│   └── exceptions/     # Tratamento global de exceções
└── services/           # Regras de negócio
    └── exceptions/     # Exceções de serviço
```

## Endpoints principais

### Auth
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| POST | `/auth/login` | Realiza login e retorna JWT | Não |

### Usuários
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| GET | `/users` | Lista todos os usuários | Sim |
| GET | `/users/{id}` | Busca usuário por ID | Sim |
| POST | `/users` | Cria novo usuário | Sim |
| PUT | `/users/{id}` | Atualiza usuário | Sim |
| DELETE | `/users/{id}` | Remove usuário | Sim |

### Produtos
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| GET | `/products` | Lista todos os produtos | Sim |
| GET | `/products/{id}` | Busca produto por ID | Sim |

### Categorias
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| GET | `/categories` | Lista todas as categorias | Sim |
| GET | `/categories/{id}` | Busca categoria por ID | Sim |

### Pedidos
| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|--------------|
| GET | `/orders` | Lista todos os pedidos | Sim |
| GET | `/orders/{id}` | Busca pedido por ID | Sim |

## Autenticação

A API utiliza autenticação **stateless com JWT**. Para acessar endpoints protegidos:

1. Faça uma requisição `POST /auth/login` com email e senha
2. Copie o token retornado no campo `token`
3. Envie o token no header de todas as requisições protegidas:

```
Authorization: Bearer {seu-token}
```

## Documentação interativa

Com o projeto rodando, acesse o Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

No Swagger você pode testar todos os endpoints diretamente pelo navegador. Para testar endpoints autenticados, clique em **Authorize** e cole o token JWT.

## Como rodar localmente

### Pré-requisitos
- Java 17+
- Maven

### Passos

**1 — Clone o repositório:**
```bash
git clone https://github.com/jusguilherme/springboot-webservices.git
cd springboot-webservices
```

**2 — Rode o projeto:**
```bash
./mvnw spring-boot:run
```

O projeto sobe no perfil `test` por padrão, usando banco H2 em memória com dados de exemplo já carregados.

**3 — Acesse o Swagger:**
```
http://localhost:8080/swagger-ui/index.html
```

**4 — Faça login com um dos usuários de exemplo:**
```json
{
  "email": "maria@gmail.com",
  "password": "123456"
}
```

## Variáveis de ambiente

| Variável | Descrição | Obrigatória em produção |
|----------|-----------|------------------------|
| `JWT_SECRET` | Chave secreta para assinar os tokens JWT (mínimo 32 caracteres) | Sim |

Em desenvolvimento local o projeto usa o valor padrão definido no `application.properties` e banco H2, sem necessidade de configurar variáveis.

## Autor

Feito por **Justino Guilherme** — [GitHub](https://github.com/jusguilherme)
