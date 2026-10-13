# Employee-Management-System
Java Servlet Employee Management System


A web-based Employee Management System developed using Java Servlets, MySQL, Maven, and Apache Tomcat. The application provides functionality to manage employee records through server-side processing and database operations.

## About the Project

The Employee Management System is designed to simplify basic employee record management. It uses Java Servlets to process HTTP requests, JDBC to interact with a MySQL database, and Apache Tomcat to run the web application.

The project follows a Maven-based structure and can be packaged as a WAR file for deployment.

## Features

* **Add Employee:** Insert employee information into the database.
* **View Employees:** Retrieve employee records from the database.
* **Search Employee:** Search for an employee using their ID or other supported details.
* **Delete Employee:** Delete an employee record using its ID.
* **Database Connectivity:** Connect the Java application to MySQL using JDBC.
* **Connection Pooling:** Use HikariCP for database connection management.
* **Maven Build:** Manage dependencies and package the application.
* **Servlet-Based Processing:** Handle HTTP requests using Java Servlets.

> Note: The features listed above should match the functionality implemented in the current version of the application.

## Technologies Used

| Technology          | Purpose                                       |
| ------------------- | --------------------------------------------- |
| Java                | Backend programming                           |
| Java Servlets       | HTTP request processing and application logic |
| HTML                | Web page structure                            |
| CSS                 | Web page styling                              |
| MySQL               | Relational database                           |
| JDBC                | Database connectivity                         |
| HikariCP            | Database connection pooling                   |
| Maven               | Dependency management and build automation    |
| Apache Tomcat 10.1  | Servlet container and application deployment  |
| Jakarta Servlet API | Servlet development for Jakarta EE            |

## Project Structure

```text
Employee-Management-System/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
│
├── src/
│   └── main/
│       ├── java/
│       │   └── EmployeeManagement/
│       │       ├── EMdbService.java
│       │       ├── Employee.java
│       │       ├── EmployeeConntion.java
│       │       ├── EmpQuery.java
│       │       ├── AllEmpServlet.java
│       │       ├── InsertServlet.java
│       │       ├── SearchServlet.java
│       │       └── DeleteBYId.java
│       │
│       └── webapp/
│           └── [HTML, JSP, CSS, and other web resources]
│
└── target/
    └── [Generated WAR file after building]
```

The structure above illustrates the main files and directories. The exact locations of the servlet classes and web resources may vary depending on the current repository.

## Prerequisites

Before running the project, install the following:

* Java Development Kit (JDK)
* Apache Maven, or use the Maven Wrapper included in the project
* Apache Tomcat 10.1 or another compatible version
* MySQL Server
* IntelliJ IDEA or another Java IDE

## Database Configuration

1. Start your MySQL server.
2. Create a database for the application.
3. Create the employee table according to the columns used in your Java code.
4. Configure the database URL, username, and password in the application's database configuration.
5. Ensure that the MySQL JDBC driver and other required dependencies are configured in `pom.xml`.

Example database creation:

```sql
CREATE DATABASE employee_management;
```

> Important: The database name, table name, column names, and connection settings must match your actual project configuration. The database name above is an example.

## Build the Project

Open a terminal in the project root directory.

On Windows, run:

```cmd
mvnw.cmd clean package
```

If the Maven Wrapper is unavailable or not configured, install Maven and run:

```cmd
mvn clean package
```

After a successful build, Maven generates the WAR file in the `target` directory.

## Run the Application

1. Build the project and generate the WAR file.
2. Start Apache Tomcat.
3. Deploy the generated WAR file to Tomcat's `webapps` directory, or configure Tomcat in your IDE.
4. Start or restart the Tomcat server.
5. Open the application in your browser using the correct context path.

Example:

```text
http://localhost:8080/Employee-Management-System/
```

The context path depends on the deployed WAR filename and your Tomcat configuration.

## Learning Outcomes

Through this project, I gained practical experience with:

* Java-based server-side web development.
* Servlet request and response handling.
* JDBC and MySQL database integration.
* Implementing database operations for employee records.
* Maven dependency management and WAR packaging.
* Deploying Java web applications on Apache Tomcat.
* Managing database connections using HikariCP.

## Future Improvements

Possible enhancements for future versions include:

* Update employee details.
* Form validation and improved error handling.
* User authentication and role-based authorization.
* Pagination for employee records.
* Improved user interface and responsive design.
* Secure database configuration using environment variables.
* Migration to Spring Boot and Spring Data JPA.

## Author

**Pavan Varma**

GitHub: [gpavanvarma](https://github.com/gpavanvarma)
