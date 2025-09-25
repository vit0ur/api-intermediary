# ⚙️ Equipamento API
API REST desenvolvida em **Java 17** com **Spring Boot**, seguindo os princípios da **arquitetura hexagonal**. 
O projeto permite o cadastro e consulta de equipamentos, com validações, tratamento de exceções, conversão entre DTOs e entidades, e busca personalizada.

## 🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot
- Maven
- JPA + Hibernate
- Banco de dados H2 (acessado via DBeaver)
- Postman
- Lombok
- JUnit
- Arquitetura Hexagonal

## 🧱 Estrutura do Projeto
```
com.proway.api_intermediary
├── controller
│   └── EquipamentoController.java
├── dtos
│   ├── EquipamentoCreateDTO.java
│   └── EquipamentoResponseDTO.java
├── exceptions
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── models
│   └── Equipamento.java
├── repositories
│   └── EquipamentoRepository.java
├── services
│   └── EquipamentoService.java
└── ApiIntermediaryApplication.java
```

## 🧪 Testes
Os testes podem ser realizados via **Postman**, utilizando os endpoints abaixo. 

## 📬 Endpoints e Exemplos de Testes no Postman

### 🔹 `POST /equipamentos` — Criar Equipamento

**Body (JSON):**
```json
{
  "nome": "Monitor LG",
  "tipo": "Monitor",
  "fabricante": "LG"
}
```

**Headers:**
```
Content-Type: application/json
```

---
### 🔹 `GET /equipamentos` — Listar Todos os Equipamentos

**Request:**
```
GET http://localhost:8080/equipamentos
```

---
### 🔹 `GET /equipamentos/{id}` — Buscar por ID

**Exemplo:**
```
GET http://localhost:8080/equipamentos/1
```

### 🔹 `GET /equipamentos/tipo/{tipo}` — Buscar por Tipo

**Exemplo:**
```
GET http://localhost:8080/equipamentos/tipo/Monitor
```

### 🔹 `GET /equipamentos/status-marca?status={status}&marca={marca}` — Buscar por Status e Marca

**Exemplo:**
```
GET http://localhost:8080/equipamentos/status-marca?status=ativo&marca=LG
```

## 🧪 Dicas para Testar no Postman
- Use a aba **Body > raw > JSON** para enviar dados no `POST`.
- Configure o **Content-Type** como `application/json`.
- Utilize a aba **Params** para enviar os parâmetros de consulta (`status`, `marca`).
- Verifique os códigos de resposta HTTP:
  - `200 OK` para sucesso
  - `400 Bad Request` para erros de validação
  - `404 Not Found` para recursos inexistentes

## 🏁 Como Executar
1. Clone o repositório
2. Execute `mvn clean install`
3. Rode a aplicação com `mvn spring-boot:run`
4. Acesse os endpoints via Postman
