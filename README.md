# Sakila Database Movie Rental Project

![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![spring_boot](https://img.shields.io/badge/-Spring%20Boot-green?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor) 
![database](https://img.shields.io/badge/-Database-orange?style=for-the-badge&logo=appveyor)
![my_sql](https://img.shields.io/badge/-My%20SQL-orange?style=for-the-badge&logo=appveyor)
![front_end](https://img.shields.io/badge/-Front%20End-purple?style=for-the-badge&logo=appveyor)
![agile](https://img.shields.io/badge/-Agile-blue?style=for-the-badge&logo=appveyor)
![scrum](https://img.shields.io/badge/-Scrum-red?style=for-the-badge&logo=appveyor)

### **Table Of Contents**
  * [**Overview**](#overview)
  * [**Technology**](#technology)
  * [**Observations**](#observations)
  * [**Screenshots**](#screenshots)
      - [Landing Page](#landing-page)
      - [Browse Films](#browse-films)
      	- [Film Details](#film-details)
      - [Browse Actors](#browse-actors)
      - [Customer Page](#customer-page)
      - [Owner Page](#owner-page)
      	- [Films' Details](#films-details)
      	- [Customers' Details](#customers-details)
  * [**Future Work**](#future-work)


## **Overview**
- A Web App front end for the Sakila database
- The database models the data associated with a film rental business
- The Web App will provide data for 3 levels of user:
	- Visitor: Will be able to see all information about films and actors (anyone who accesses the Web App with no credentials)
		- Browsing for films and actors made easier
		- Able to search by a specific film title, actor first/last name or film category
	- Customer: Will be able to see their own account information including which films they have rented
		- Allows for personalised experience for each customer
		- Able to rent a specific film
	- Owner: Has all levels of access and can write to the database, i.e creating new customers and adding films. Can see all customer information and films that have been taken out
		- Allows for organised control when it comes to owners
		- Able to update the information of a specific film
		- Able to delete a specific film


## **Technology**
- Spring Boot
	- As a Java-based framework
- Thymeleaf
	- As a Java-based templating engine
- My SQL
	- As a database
- JUnit
	- Including Mock testing
- Scrum Framework within Agile


## **Observations**
- The entire project was built in less than 3 days as means of learning how to prioritise requirements in an agile environments
- Altering a database was the main struggle we faced with due to numerous primary-foreign key relationships between tables


## **Screenshots**

### **Landing Page**

### **Browse Films**

#### **Film Details**

### **Browse Actors**

### **Customer Page**

### **Owner Page**

#### **Films' Details**

#### **Customers' Details**


## **Future Work**
- Allow user to type the input, instead of filtering it
- Allow search for films by language
- Allow for changes in the inventory to be made to reflect the most up to date rental status
- Edit/delete user functionality





