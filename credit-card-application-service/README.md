# Publicis Sapient Credit Card Application Service

## Overview

The purpose of this project is to store and retrieve a list of credit card and its details.

The project has:
 - In memory Database to store the credit card details

#TODO
The runnable artifacts should be deployed in AWS ECS Cluster using AWS CICD Approach

### Development Environment Setup

Install Lombok:

 * https://projectlombok.org/setup/eclipse
 * https://projectlombok.org/setup/intellij

### Maven Build

```
./mvnw clean install (optionally -DskipTests)
```

### Tests

All tests ending in *Test.java will contribute to code coverage and will be automatically executed by the Maven build Surefire plugin. Alternatively the tests can be triggers with:

```
./mvnw test
```

To run both sets of Tests execute the following goal:

```
./mvnw verify
```

Note: The verify goal will execute automatically by ``./mvnw install``

### Run Credit Card Application Service API (CLI)

```
java -jar credit-card-application-service/target/*.jar
```

#### Database Setup

By default the API will use an in-memory database to be able to very quickly test the API.

#### Swagger API

please access the below URL for the available REST APIs
http://localhost:8080/swagger-ui.html#/

