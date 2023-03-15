# RecipeManagementAppication
### Frameworks and languages Used
* Spring
* Spring Boot
* Java
### Data Flow(Functions used In)
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
## EndPoints
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
## DataBase Design
I used MySQL database. I downloaded one Spring Boot Application from spring inializr by adding required dependencies. Created model for Cook, Recipe, Instructions. I used Java persistence API.Controller , Service and repository are created. I used Crud operations for retriving, upadating, deletiong and adding the data.
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

# Working
* In this project we mainly focus on the deployment of project in the EC2 which is provided by the AWS(Amazon web services).
* In this project we deployed the project with the help of the termius.
* Recipe manaagement Application is a Rest API application which is built by using spring boot as framework.
* This project consist of Three models namely Cook,Instruction, Recipe. Comments along with their corresponding dao classes, controller classes and service classes.
* Created Repository for CookRepo, RecipeRepo, InstructionRepo.
* Performed Annotation validation on all the Model class present in the MVC.
* Relationship between Models or tables are given accordingly, relationship given as such of @ManyToOne for Cook where more than one Recipe can have one cook. 
* This project is deployed online with IP:34.215.54.235 using Termius along with the help AWS-EC2 using various linus commands so that the mysql database and commands works on it.
