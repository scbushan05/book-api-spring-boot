# BOOK API - Spring Boot, MySQL, JPA Rest API Tutorial

Build Restful CRUD API for a simple Book-Manage application using Spring MVC, Mysql and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.3.9

3. MySQL - 5.7.12    

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/scbushan05/book-api-spring-boot.git
```

**2. Create Mysql database**

```bash
create database bookdb
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/db.properties`

+ change `mysql.user` and `mysql.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/bookapi-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/book
    
    POST /api/book
    
    GET /api/book/{bookId}
    
    PUT /api/book/{bookId}
    
    DELETE /api/book/{bookId}

You can test them using postman or any other rest client.

## Learn more

You can find the tutorial for this application on my blog -
