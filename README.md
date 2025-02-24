
# Employee Management API (CRUD)

A simple and well-structured **REST API** built with **Spring Boot** for managing employee records. This project follows industry best practices, ensuring clean architecture, modularity, and maintainability.

## ✨ Features

- 🚀 **CRUD Operations** – Create, Read, Update, and Delete employees.
- 🌍 **RESTful API** – Follows RESTful design principles.
- 🛠️ **Spring Boot & JPA** – Built using **Spring Boot** and **Spring Data JPA** for seamless database operations.
- 🗄️ **Database Support** – Supports **MySQL**.
- 🏗 **Clean Architecture** – Proper layering with DTOs, Service, and Repository layers.
- ⚙️ **Best Practices** – Includes exception handling, validation, and structured API responses.

---

## 📌 Tech Stack

- **Spring Boot** – Backend framework
- **Spring Data JPA** – ORM for database interactions
- **MySQL** – Database options
- **Lombok** – Reduces boilerplate code
- **Spring Validation** – Validates API requests
- **Postman** – API testing

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/saumik-talukdar/employee-management-api-crud.git
cd employee-management-api-curd
```

### 2️⃣ Configure Database (Optional)

- Default: Uses **H2 in-memory database** (No setup required)
- For **PostgreSQL** or **MySQL**, update `application.properties` in `src/main/resources/`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Build & Run the Application

```sh
mvn clean install
mvn spring-boot:run
```

The API will be available at: `http://localhost:8080/api/employee`

---

## 📜 API Endpoints

| Method | Endpoint             | Description            |
|--------|----------------------|------------------------|
| GET    | `/api/employee`      | Get all employees     |
| GET    | `/api/employee/{id}` | Get employee by ID    |
| POST   | `/api/employee`      | Create a new employee |
| PUT    | `/api/employee/{id}` | Update an employee    |
| DELETE | `/api/employee/{id}` | Delete an employee    |

📌 **Example Request (Create Employee)**

```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "position": "Software Engineer"
}
```

---

## 🛠 Project Structure

```
src/main/java/com/saumik/employee/
├── controller/      # API controllers
├── service/         # Business logic
├── repository/      # Data access
├── dto/             # Data Transfer Objects (DTOs)
├── exception/       # Custom exception handling
└── entity/           # Entity models
```

---

## 📌 Best Practices Implemented

✅ **Layered Architecture** (Controller → Service → Repository)  
✅ **DTOs** for request/response structure  
✅ **Exception Handling** with `@ControllerAdvice`  
✅ **Global Validation** using `@Valid`  
✅ **Proper HTTP Status Codes** with `ResponseEntity`

---

## 📝 License

This project is open-source and available under the **MIT License**.

---

🚀 **Happy Coding!** 😊