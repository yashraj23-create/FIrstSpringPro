TripMate CRUD Backend
📌 Overview

TripMate is a simple CRUD-based backend application built with Spring Boot that allows users to manage trip-related information.
This version focuses on trip creation, retrieval, and deletion — updating trips is intentionally excluded, as real trips can’t be altered once completed.

🚀 Features

Create a new trip record

Retrieve all trips or a specific trip by ID

Delete a trip by ID

No update functionality (design choice)

Built using Spring Boot, JPA, and MySQL

🛠 Tech Stack

Java (Spring Boot)

Spring Data JPA for database access

MySQL as the database

Swagger UI for API documentation

Maven for dependency management

📂 API Endpoints
Method	Endpoint	Description
POST	/trips	Create a new trip
GET	/trips	Get all trips
GET	/trips/{id}	Get a trip by ID
DELETE	/trips/{id}	Delete a trip by ID
POST	/user	Create a new user
GET	/user	Get all users
GET	/user/{id}	Get a user by ID
DELETE	/user/{id}	Delete a user by ID
POST	/destination	Create a new user
GET	/destination	Get all destinations
GET	/destination/{id}	Get a destination by ID
DELETE	/destination/{id}	Delete a destination by ID
POST	/auth/signin	Creates auth for user
POST	/auth/login	login to account
⚙ Setup & Installation

Clone the repository:

git clone https://github.com/yourusername/tripmate-crud.git


Navigate to the project directory:

cd tripmate-crud


Configure your database in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/tripmate
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Build and run the project:

mvn spring-boot:run

📜 API Documentation

Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

📌 Note

This is a backend-only CRUD project without frontend.
The update operation was excluded by design to mimic real-life trip booking scenarios.
