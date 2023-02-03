# 👨‍🏭️ Auto-service
A RESTful application created using Spring Boot. The application helps manage orders, services and products, as well as calculate wages and the cost of the order.

## ✨Features✨
* Creation of new entities such as: Car, Owner, Product, Master, Service, Order.
* Calculation of the cost of the Order.
* Calculation and issuance of wages to the Master.
* Editing Entity Data.
* Changing Order/Service statuses.

## :computer: Technologies
* Spring Boot
* JDK 17
* Apache Maven
* PostgreSQL
* JPA, Hibernate
* Swagger
* Docker

## :clipboard: Project structure

* `@RestController:` Reads **POST/GET** requests and use autowired **services, mappers** and **DTO** for create and return response.
* `@Service:` Interacts with **DAO** level and contains business logic.
* `@Repository` or **DAO** level: interacts with database.
* 'Data tier': data store/retrieve layer.

## List of available end-points:

* POST: /cars - creates a new car entity and saves it to db;
* PUT: /cars/{id} - updates all car fields by its id;
* POST: /masters - creates a new master entity and saves it to db;
* PUT: /masters/{id} - updates all master fields by its id;
* GET: /masters/{id}/orders - returns all master orders by its id;
* POST: /orders - creates a new order entity and saves it to db;
* PUT: /orders/{id} - updates all order fields by its id;
* PUT: /orders/{id}/add-product - adds product id to product ids list of order by its id;
* PUT: /orders/{id}/status - updates order status by its id;
* GET: /orders/{id}/cost - calculates final price of order by its id;
* POST: /owners - creates a new car entity and saves it to db;
* PUT: /owners/{id} - updates all owner fields by its id;
* GET: /owners/{id}/orders - returns all owner orders by its id;
* POST: /products - creates a new product entity and saves it to db;
* PUT: /products/{id} - updates all product fields by its id;
* POST: /services - creates a new service entity and saves it to db;
* PUT: /services/{id} - updates all service fields by its id;
* PUT: /services/{id}/status - updates service status by its id;
