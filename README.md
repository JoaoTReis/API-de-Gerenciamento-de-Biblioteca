## 📚 **Library Manager - REST API**

### 🚀 **Description**

This REST API was developed to manage libraries, allowing control over books, authors, and genres. It provides CRUD operations (Create, Read, Delete) to efficiently manage data.

---

### 🔧 **Available Features**

- **Books**  
  - List all books  
  - Get book by ID  
  - Add a new book  
  - Delete a book  

- **Users**  
  - List all users  
  - Get user by ID  
  - Add a new user  
  - Update user data  
  - Delete a user  

---

### 🛠️ **Technologies Used**

- **Language:** Java 17  
- **Framework:** Spring Boot  
- **Database:** PostgreSQL  
- **Persistence:** JPA with Hibernate  
- **Dependency Management:** Maven  

---

### 🛀 **How to Run the Project**

#### Prerequisites

- Java 17+  
- Maven  
- PostgreSQL installed and configured  

#### Steps  

1. Clone the repository:

   ```bash
   git clone https://github.com/your-user/your-repository.git
   cd your-repository
   ```

2. Configure the environment profiles in the `application.properties` file:

   ```properties
   spring.profiles.active=prod
   spring.jpa.open-in-view=true
   ```

3. Configure the database in the `application-prod.properties` file:

   ```properties
   spring.datasource.url=jdbc:postgresql://dpg-cul990in91rc73e8se6g-a:5432/api_biblioteca_zu19
   spring.datasource.username=api_biblioteca_zu19_user
   spring.datasource.password=Init9aVtzBjv3aEb69vW986SO7HF64pQ
   
   spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   
   jwt.secret=MYJWTSECRET
   jwt.expiration=3600000
   ```

4. Build the project:

   ```bash
   mvn clean install
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

6. Access the API at the following URL:

   ```
   http://localhost:8080/api/livros
   ```

---

### 📖 **API Endpoints Examples**

**1. List all books**  
```
GET /api/livros
```

**2. Get a book by ID**  
```
GET /api/livros/{id}
```

**3. Add a new book**  
```
POST /api/livros
Content-Type: application/json
{
  "titulo": "The Lord of the Rings",
  "autor": "J.R.R. Tolkien",
  "genero": "Fantasy"
}
```

**4. Delete a book**  
```
DELETE /api/livros/{id}
```

**5. List all users**
```
GET /api/usuarios
```

**6. Get a user by ID**
```
GET /api/usuarios/{id}
```

**7. Add a new user**  
```
POST /api/usuarios
Content-Type: application/json
{
  "nome": "John Doe",
  "email": "john.doe@email.com"
}
```

**8. Update user data**  
```
PUT /api/usuarios/{id}
Content-Type: application/json
{
  "nome": "John Doe Updated",
  "email": "john.doe.new@email.com"
}
```

**9. Delete a user**  
```
DELETE /api/usuarios/{id}
```

---

### 👥 **Contributions**

Contributions are welcome! Feel free to open issues and submit pull requests.

---

### 📧 **Contact**

For questions or suggestions, feel free to contact:

- Email: [joaoteireis@gmail.com](mailto:joaoteireis@gmail.com)  
- LinkedIn: [João T. Reis](https://www.linkedin.com/in/joao-t-reis)

