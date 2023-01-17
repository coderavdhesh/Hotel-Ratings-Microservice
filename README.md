# Hotel-Ratings-Microservice : 
**It is a Hotels rating backend service like in Airbnb, OYO rooms, Booking.com, agoda etc. built on microService architecture**

This whole project gave me a beeter and clear understanding in developing microservices.
> The flow of my working/learning :
1. This is a fully independent service developed based on **microservice architecture using Spring boot** that connects to the **MySQL database** with the help of **Spring data JPA(CRUD/JPA repo).** 
2. This microservice connects **3 services(API)**, i.e User_service, Hotel_service and Rating_service, and allow (intenal)**communication** among them(using **restTemplete** config.), **Note:** Every single service(API) is having there own Database.
3. I **developed a Euraka server(also an API)** and register them to convert the hard coded URI into a **common URL** so we don't have to use individual URLs of each service.
4. Now to make this whole architecture independent, I built the **single Api_gateway** to call all the services(APIs) using the common URIs.
5. In the End, I used **Spring Cloud** configuration to make my microservice lighter by **uploading the configuration profiles on cloud**.


## Requirements

1. Java - 17

2. Maven - 3.x.x

3. Mysql - 5.x.x or Ternimal 

4. StringBoot - 3.x.x

5. Visual Studio Code(VScode)

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/coderavdhesh/Hotel-Ratings-Microservice.git
```

**2.1 : Create Mysql database**
```bash
create database microservice
```

**2.2 : Create select Database**
```bash
use microservice
```

**2.3 : Create Tables in database**
```bash
Note : My written code will automatically generate their tables itself. However you can follow there SQL commands in terminal/workbanch.

    create table user_data;
    create table rating_data;
    create table hotel_data;
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven (BookCart)**

```bash
java -jar target/user_data.jar
java -jar target/hotel_data.jar
java -jar target/rating_data.jar
java -jar target/api_gateway.jar
java -jar target/configuration.jar
```

Alternatively, you can run the app without packaging it using(or using VS code to run your app)-

```bash
mvn spring-boot:run
```

## Tomcat server port numbers :
The **app(api_gateway)** will start running at <http://localhost:8094>

The **User Service** will start running at <http://localhost:8091>

The **Hotel Service** will start running at <http://localhost:8092>

The **Rating Service** will start running at <http://localhost:8093>

.
## Explore Rest APIs URIs

The app defines following CRUD APIs.

These all the users will works, once you connect all your services in single api_gateway:


    localhost:8094/users
    localhost:8094/users/users/{user_Id}
    localhost:8094/users/hotels
    localhost:8094/users/hotels/{hotel_Id}
    localhost:8094/users/rating
    localhost:8094/users/rating/{rating_Id}

<img width="263" alt="Screenshot 2023-01-17 at 5 53 39 PM" src="https://user-images.githubusercontent.com/61471356/212911949-c80fa40f-5319-477f-a557-979ce79f4cf9.png">

You can test them using postman or any other rest client.

## **API Documentation -** Please refer this postman document for more clarity
 https://documenter.getpostman.com/view/24533269/2s8ZDVYNjg


## **Know More**

                    Hotel-Ratings-Microservice Project

>Key Learnings:
 ### Tech Stacks :
  >Springboot, Spring Data JPA, MySQL Database, SQL, Postman client tool, Java, Spring annotations, Spring MVC(controllers, HTTP URIs), classpath & dependencies, configuration, etc.       

1. New learing and gained more confidence in developing microservices.
2. Learn about Eureka servers and Service-Registery and  internal communication of APIs.             
3. More clarity and understanding actually working in Backend, Layers in the backend development.
4. Familiar with SpringBoot-Architectural Layers and how they are working together to get the data from the database to the end user.
5. How we can connect our API with our Database with the help of Spring Data JPA and with full functionality of CRUDs with your APIs.
6. Got familiar with the CRUD methods of JPA repo and Database configurations.
7. How we can test/check the working of our backend service/APIs using 'POSTMAN TOOL'
8. More clarity in core Java concepts.
-----------------------------------------------------------------------------------------------
>Used Tools and other Services: 
1. Postman API tool to get the reponses.
2. MySQL server and Interaction with database through terminal.
3. VS code to manage this project.
4. Git(github) to upload this source Code.
5. No frontend written yet for this Backend service.
-----------------------------------------------------------------------------------------------



````
**************** Happy Coding ******************
