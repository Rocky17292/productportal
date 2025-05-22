# 📦 ProductPortal – Spring Boot Assignment

A Spring Boot-based web application that demonstrates:
- 🔐 JWT-based Authentication and Authorization
- 👥 Role-based access for **Admin** and **Customer**
- 📦 Full Product Management (CRUD)
- 🧪 API testing using Swagger UI
- 💾 MS SQL Server integration (via Spring Data JPA)

---

## 🔑 Features

### 👤 Authentication
- `POST /auth/signup` – Register as Admin or Customer
- `POST /auth/login` – Login and get JWT token

### 🔐 Admin APIs (`/admin/products`)
- Add, Edit, Delete products
- Toggle visibility to customers
- View all or specific products

### 👁️ Customer APIs (`/customer/products`)
- View visible products
- Get product details

---

## 💻 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security + JWT
- Spring Data JPA
- MS SQL Server
- Swagger UI (SpringDoc OpenAPI)
- Eclipse IDE (No Lombok used)

---

## ⚙️ Configuration (`application.properties`)

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=product_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

🚀 How to Run
mvn clean install
mvn spring-boot:run


🔎 Swagger API Docs
After starting the application, open:
http://localhost:8080/swagger-ui/index.html

Click "Authorize" and enter:
Bearer <your-token-here>

📂 Folder Structure
com.assignment.productportal
├── controller
├── dto
├── model
├── repository
├── security
├── service
└── config

👨‍💻 Author
Rushikesh Shinde
