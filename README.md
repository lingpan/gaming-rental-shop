
# Spring Boot Shopping Cart Web App Version 0.0.2

## About

It was made using **Spring Boot**,  **Thymeleaf**, **Spring Data JPA**, **Spring Data REST and Docker**.
Database is **H2** in file.

- Users can search and shop for Game. 
- Search results are paginated. 
- Click on each row will bring detail page for the game
- Each user has his own shopping cart (session functionality).
- Can add/update quantity/remove items in the shopping cart.

## New features in 0.0.2
- The latest version now includes caching capabilities, significantly enhancing the overall user experience.


## How to start Redis Server
1. Follow this instruction to install Redis on your operating system. https://redis.io/docs/getting-started/installation/
2. Start redis-server 
3. ```bash
   $ redis-server
    ``` 
Spring Redis configuration can be changed In /src/main/resources/application.properties file


## How to run

There are several ways to run the application. You can run it from the command line with included Maven Wrapper, Maven or Docker.

Once the app starts, go to the web browser and visit `http://localhost:8080/`


### Maven Wrapper

#### Using the Maven Plugin

Go to the root folder of the application and type:
```bash
$ chmod +x mvnw
$ mvnw spring-boot:run
```

#### Using Executable Jar

Or you can build the JAR file with
```bash
$ mvnw clean package
``` 

Then you can run the JAR file:
```bash
$ java -jar target/gameRental-0.0.1-SNAPSHOT.jar
```

### Docker

It is possible to run **shopping-cart** using Docker:

Build Docker image:
```bash
$ mvn clean package
$ docker build -t game_rental:0.0.1 -f docker/Dockerfile .
```

Run Docker container:
```bash
$ docker run --rm -p 8080:8080 --name game-rental game_rental:0.0.1
```


### H2 Database web interface

Go to the web browser and visit `http://localhost:8080/h2-ui`

In field **JDBC URL** put
```
jdbc:h2:file:./testdb
```
h2 console url can be changed In /src/main/resources/application.properties file

## Future Improvement
- Improve page loading speed
- Robust Search
- Caching



