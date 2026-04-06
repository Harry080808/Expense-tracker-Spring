### **Expense Tracker Financial Dashboard backend with Spring boot**



##### Technology - Java

##### Framework - Spring boot

##### Database - MySQL(RDBMS)

##### backend Interface - REST API

##### Build Tool - Maven



1. Main Package  - src/main/java - In this package we have com.example.Expense-Tracker package - in this we have ExpenseTrackerApplication.java :- This file is the entry point of the program That starts spring application



a) Cotroller package - This Layer is responsible for handling request and response in the backend. This is the layer where request comes first

&#x09;1. UsersController.java - this file handles request related to users creation, updation and deletion of user profile.

&#x09;2. TransController.java - this file handles the request related to transaction/expense of the users. 

&#x09;3. DashboardOpsController.java - this file handles the request and response of the dashboard summary and data.



b) Service Package - This layer is responsible for writing business logic and communication with model and database(repo).

&#x09;1. UserService.java - This file writes the logic of user profile and communicate with database. in database there is the user table.

&#x09;2. TransService.java - This file communicate with transaction table. It uses Transaction model to hold data of expense of user.

&#x09;3. DashboardService.java - This file writes the logic of calculation all expenses of users and convert it into meaningful insights. This file also calculates the category-wise total expense of each user.



c) Model package - This layer is responsible for creating table in database. It uses hibernate ORM tool to convert class to table-name and fields to column-name.

&#x09;1. User.java - This class have all the fields needed to create user table. such as name, id, email, role, etc.

&#x09;2. Transaction.java - This class have fields which stores the expenses information such as expense-name, date, amount, etc.

&#x09;3. DashBoard.java - This class have the fields related to dashboard info such as total expense, net balance, etc.



d) Repository package - This layer takes care of database and table creation in backend. It uses Hibernate to automatically create tables and constraints. for that we need to add Spring Data JPA dependency.

&#x09;1. UserRepo.java - This is the interface which extends Jparepository which has in-built method of basic CRUD operation. This repo creates the user table in database and in every request it stores the user record.

&#x09;2. TransRepo.java - This is also an interface which creates transaction table in database automatically. no need to write sql queries manually.

=======
# Expense-tracker-Spring
