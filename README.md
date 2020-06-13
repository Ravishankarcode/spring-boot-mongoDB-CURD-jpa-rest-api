# Spring Boot, MongoDB, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a simple User-Creation application using Spring Boot, MongoDB, JPA and Hibernate.

## Requirements

1. Java    - 1.8.x

2. Maven   - 3.x.x

3. MongoDB - 4.2.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/Ravishankarcode/spring-boot-mongoDB-CURD-jpa-rest-api.git
```

**2. Run MongoDB database**
```bash
>mongod
>mongo
>use test
```

**3. Build and run the app using maven**

```bash
mvn package
java -jar target/mongo-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/users
    
    POST /api/users
    
    GET /api/users/{firstname}
    
    PUT /api/users/{firstname}
    
    DELETE /api/users/{firstname}

You can test them using postman or any other rest client.

## Learn more

You can find the tutorial for this application on my blog -

<https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/>
