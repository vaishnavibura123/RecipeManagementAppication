# RecipeManagementAppication
### Requirements
* IntelliJIDEA
* ServerPort: 8080 (use: localhost:8081)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)
* terminus
* EC2 
### Steps to run the Project
* Click on the Swagger URL which is pasted below and perform the operations
http://34.215.54.235:8080/swagger-ui/index.html#/
# Dependencies
## Validation
* Bean Validation with Hibernate validator.
## Spring Web
* Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
## Spring Boot DevTools
* Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
## Spring Data JPA
* Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
## Lombok
* Java annotation library which helps to reduce boilerplate code.
## MySQL
* MySQL JDBC driver.
## Swagger
* It provide the UserInterface for all our API's. 
# Project Structure(MVC Structure)
## Model
* Cook
* Recipe
* Instructions
## Controller
* CookController
* RecipeController
* InstructionsController
## Service
* CookService
* RecipeService
* InstructionsService
## Repository
* CookRepo
* RecipeRepo
* InstructionsRepo
# EndPoints
## Cook
* addCook
* getAll
* getById
* deleteCook
* updateCook
* getPost
## Recipe
* addRecipe
* getAll
* getById
* deleteRecipe
* updateRecipe
## Instructions
* addInstructions
* getAll
* getById
* deleteInstructions
* updateInstructions
# Working
* In this project we mainly focus on the deployment of project in the EC2 which is provided by the AWS(Amazon web services).
* In this project we deployed the project with the help of the termius.
* Recipe manaagement Application is a Rest API application which is built by using spring boot as framework.
