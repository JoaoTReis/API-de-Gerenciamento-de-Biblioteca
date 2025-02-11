## 📚 **Gerenciador de Biblioteca - API REST**

### 🚀 **Descrição**

Esta API REST foi desenvolvida para gerenciar bibliotecas, permitindo o controle de livros, autores e gêneros. Ela oferece operações CRUD (Create, Read, Delete) para gerenciar os dados de forma eficiente.

---

### 🔧 **Recursos Disponíveis**

- **Livros**  
  - Listar todos os livros  
  - Consultar livro por ID  
  - Adicionar novo livro  
  - Remover livro

- **Usuários**  
  - Listar todos os usuários  
  - Consultar usuário por ID  
  - Adicionar novo usuário  
  - Atualizar dados de um usuário  
  - Remover usuário

---

### 🛠️ **Tecnologias Utilizadas**

- **Linguagem:** Java 17  
- **Framework:** Spring Boot  
- **Banco de Dados:** PostgreSQL  
- **Persistência:** JPA com Hibernate  
- **Gerenciamento de Dependências:** Maven  

---

### 🛀 **Como Executar o Projeto**

#### Pré-requisitos

- Java 17+  
- Maven  
- PostgreSQL instalado e configurado  

#### Passos  

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. Configure os perfis de ambiente no arquivo `application.properties`:

   ```properties
   spring.profiles.active=prod
   spring.jpa.open-in-view=true
   ```

3. Configure o banco de dados no arquivo `application-prod.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_demo
   spring.datasource.username=postgres
   spring.datasource.password=1212001
   
   spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   
   jwt.secret=MYJWTSECRET
   jwt.expiration=3600000
   ```

4. Compile o projeto:

   ```bash
   mvn clean install
   ```

5. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

6. Acesse a API na URL:

   ```
   http://localhost:8080/api/livros
   ```

---

### 📖 **Exemplos de Endpoints**

**1. Listar todos os livros**  
```
GET /api/livros
```

**2. Consultar um livro por ID**  
```
GET /api/livros/{id}
```

**3. Adicionar um novo livro**  
```
POST /api/livros
Content-Type: application/json
{
  "titulo": "O Senhor dos Anéis",
  "autor": "J.R.R. Tolkien",
  "genero": "Fantasia"
}
```

**4. Excluir um livro**  
```
DELETE /api/livros/{id}
```

**5. Listar todos os usuários**
```
GET /api/usuarios
```

**6. Consultar um usuário por ID**
```
GET /api/usuarios/{id}
```

**7. Adicionar um novo usuário**  
```
POST /api/usuarios
Content-Type: application/json
{
  "nome": "João da Silva",
  "email": "joao.silva@email.com"
}
```

**8. Atualizar dados de um usuário**  
```
PUT /api/usuarios/{id}
Content-Type: application/json
{
  "nome": "João da Silva Atualizado",
  "email": "joao.silva.novo@email.com"
}
```

**9. Excluir um usuário**  
```
DELETE /api/usuarios/{id}
```

---

### 👥 **Contribuições**

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

---

### 📧 **Contato**

Para dúvidas ou sugestões, entre em contato:

- Email: [joaoteireis@gmail.com](mailto:joaoteireis@gmail.com)  
- LinkedIn: [João T. Reis](https://www.linkedin.com/in/joao-t-reis)

