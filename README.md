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
