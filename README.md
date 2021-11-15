[![CircleCI](https://circleci.com/gh/pictet-technologies-open-source/graphql-demo/tree/main.svg?style=shield&circle-token=e130d37bbd598ce4274446d5c0aa94f3206501af)](https://circleci.com/gh/pictet-technologies-open-source/graphql-demo)
[![CodeFactor](https://www.codefactor.io/repository/github/pictet-technologies-open-source/graphql-demo/badge?s=b1bb2e87ea6dde7623a129a138039c56811bd50f)](https://www.codefactor.io/repository/github/pictet-technologies-open-source/graphql-demo)

# Learn how to develop efficient and simplified applications using GraphQL

This project builds a Travel agency web application with **Spring Boot**, **GraphQL**, **Angular** and **RDBMS**.
It helps clients to manage operations related to flight bookings for trips. It also compares the REST implementation of the CRUD operations with that of GraphQL.

### Project structure


Folder                    | Description
--------------------------|--------------------------------------------------------------
graphql-app               | Spring boot application (back-end)
graphql-ui               | Angular application (front-end)


### Local environment

#### Build the application

In order to build the application you need to have the following software installed:
- open JDK or oracle JDK >= 8
- npm

#### Connect to H2

- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:TRAVEL_AGENCY;TRACE_LEVEL_SYSTEM_OUT=1;MODE=ORACLE;DB_CLOSE_DELAY=11;
- User Name: admin
- Password: 

After clicking on the 'Connect' button, you should be able to execute SQL queries on the database.

#### Start the application

Start the Backend:

```
$ mvn clean install
$ mvn spring-boot:run
```
Start the Frontend:

```
$ ng serve
```

Once the application starts, you can access it using the following links :

Name                      | Link
--------------------------|--------------------------------------------------------------
UI                        | http://localhost:4200
GraphQL Playground                | http://localhost:8083/playground
H2 console                   | http://localhost:8083/h2-console


