# 📦 Sistema de Controle de Pedidos

Este é um projeto backend desenvolvido em **Java** com **Spring Boot**, que gerencia clientes e pedidos. Ele inclui operações CRUD e está documentado com **Swagger**.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI (Swagger)**
- **Maven**

## ⚙️ Funcionalidades

### 📌 Clientes
- Criar, listar, atualizar e excluir clientes.
- Restrição para impedir exclusão de clientes com pedidos associados.

### 📌 Pedidos
- Criar, listar, atualizar status e excluir pedidos.
- Associação entre clientes e pedidos.

### 📌 Documentação com Swagger
- Disponível em `/swagger-ui.html` após iniciar o projeto.

## ▶️ Como Executar o Projeto

1. **Clone o repositório**  
   ```bash
   git clone https://github.com/O-Alexsandro/Controle-de-pedidos.git

2. **Acesse o diretório do projeto**  
   ```bash
   cd controle

3. **Execute o projeto com Maven**  
   ```bash
   mvn spring-boot:run

4. **Acesse a API via: http://localhost:8080**
   
5. **Documentação Swagger disponível em:**  
   ```bash
   http://localhost:8080/swagger-ui.html

## 🛠️ Melhorias Futuras

- **Implementação de autenticação e autorização.**
- **Integração com um banco de dados relacional (PostgreSQL ou MySQL)**
- **Testes automatizados com JUnit e Mockito.**

---
👨‍💻 Desenvolvido por [Alexsandro Oliveira Ribas](https://github.com/O-Alexsandro)

