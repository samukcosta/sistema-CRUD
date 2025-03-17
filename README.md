# 🛠 Sistema CRUD

Sistema CRUD é um projeto desenvolvido em **Java** utilizando **Spring Boot** para gerenciar clientes e produtos. Ele fornece uma API REST para operações de **Create, Read, Update e Delete (CRUD)**, facilitando a administração dessas entidades.

Este sistema foi desenvolvido como parte da disciplina **Desenvolvimento de Sistemas Web II** na **Universidade Federal do Rio Grande do Norte (UFRN)**. O objetivo do projeto foi criar um CRUD completo para clientes e produtos, seguindo boas práticas de desenvolvimento com **Spring Boot** e **JPA**.

## 🚀 Tecnologias Utilizadas

- ☕ **Java** 17+
- 🌱 **Spring Boot** 3+
- 🗄 **Spring Data JPA** (para persistência de dados)
- 💾 **MySQL** (banco de dados relacional)
- 🔗 **Spring Web** (para criação da API REST)
- 🧪 **JUnit** e **Mockito** (para testes automatizados)
- 📦 **Lombok** (para reduzir código boilerplate)

## 📂 Estrutura do Projeto

```
Sistema-CRUD/
│── .mvn/wrapper/
│── .gitattributes
│── .gitignore
│── README.md
│── mvnw / mvnw.cmd
│── pom.xml
│── src/
│   ├── main/java/br/ufrn/imd/samuelAraujoCosta/
│   │   ├── controllers/
│   │   │   ├── ClienteController.java
│   │   │   ├── ProdutoController.java
│   │   ├── dto/
│   │   │   ├── ClienteDTO.java
│   │   │   ├── ProdutoDTO.java
│   │   ├── model/
│   │   │   ├── ClienteEntity.java
│   │   │   ├── GeneroCliente.java
│   │   │   ├── GeneroProduto.java
│   │   │   ├── ProdutoEntity.java
│   │   ├── repositories/
│   │   │   ├── ClienteRepository.java
│   │   │   ├── ProdutoRepository.java
│   │   ├── SamuelAraujoCostaApplication.java
│   ├── main/resources/
│   ├── test/java/br/ufrn/imd/samuelAraujoCosta/
```

## 📌 Endpoints Disponíveis

### 📍 ClienteController

| Método | Endpoint          | Descrição                          |
|--------|------------------|----------------------------------|
| GET    | `/clientes`       | Lista todos os clientes          |
| GET    | `/clientes/{id}`  | Busca um cliente por ID          |
| POST   | `/clientes`       | Cria um novo cliente             |
| PUT    | `/clientes/{id}`  | Atualiza um cliente por ID       |
| DELETE | `/clientes/{id}`  | Remove um cliente do sistema     |

### 📍 ProdutoController

| Método | Endpoint          | Descrição                          |
|--------|------------------|----------------------------------|
| GET    | `/produtos`       | Lista todos os produtos          |
| GET    | `/produtos/{id}`  | Busca um produto por ID          |
| POST   | `/produtos`       | Cria um novo produto             |
| PUT    | `/produtos/{id}`  | Atualiza um produto por ID       |
| DELETE | `/produtos/{id}`  | Remove um produto do sistema     |

## 📖 Modelos de Dados

### 🧑 ClienteEntity
```java
public class ClienteEntity {
    private Long id;
    private String nome;
    private String cpf;
    private GeneroCliente genero;
    private LocalDate dataNascimento;
}
```

### 📦 ProdutoEntity
```java
public class ProdutoEntity {
    private Long id;
    private String nomeProduto;
    private String marca;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private GeneroProduto genero;
    private String lote;
}
```

## 🔧 Banco de Dados

- O sistema utiliza **MySQL** como banco de dados relacional.
- As tabelas são criadas automaticamente pelo **Spring JPA**.
- Nome das tabelas:
  - `clientes`
  - `produtos`

## ▶️ Como Executar o Projeto

1. 📥 Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/sistema-CRUD.git
   ```
2. 🛠 Acesse a pasta do projeto:
   ```sh
   cd sistema-CRUD
   ```
3. ⚙️ Configure o banco de dados MySQL no `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/imd_market
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
4. 🚀 Execute a aplicação:
   ```sh
   ./mvnw spring-boot:run
   ```
   Ou, no Windows:
   ```sh
   mvnw.cmd spring-boot:run
   ```
5. 🌍 Acesse a API no navegador ou em um cliente REST como Postman:
   ```
   http://localhost:8080
   ```

## 🧪 Testes Automatizados

Para rodar os testes:
```sh
./mvnw test
```

## 🤝 Contribuição

1. 🍴 Fork o repositório.
2. 🌿 Crie uma branch com sua feature:
   ```sh
   git checkout -b minha-feature
   ```
3. 💾 Commit suas alterações:
   ```sh
   git commit -m 'Adicionando nova funcionalidade'
   ```
4. ⬆️ Envie para o repositório:
   ```sh
   git push origin minha-feature
   ```
5. 🔄 Abra um Pull Request.

## 📜 Licença

Este projeto está sob a licença MIT - veja o arquivo LICENSE para mais detalhes.

---

## 📞 Contato

Feito com ❤️ por **Samuel Costa** 👋🏽

[![Linkedin Badge](https://img.shields.io/badge/-Samuel%20Costa-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/costa-samuel/)](https://www.linkedin.com/in/costa-samuel/)
[![Gmail Badge](https://img.shields.io/badge/-samu.ks@outlook.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:samu.ks@outlook.com)](mailto:samu.ks@outlook.com)
