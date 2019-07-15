SpringBoot JPA Mapping Example
==============================

What is it?
-----------

This is your project! It is a sample, deployable Maven 3 project to help you get your foot in the door developing with SpringBoot. 

This project is setup to allow you to create a compliant SpringBoot JPA application using Spring REST. 

System requirements
-------------------

All you need to build this project is Java 8.0 (Java SDK 1.8) or better, Maven 3.0 or better.

The application this project produces is designed to be run on embedded Tomcat. 

Build and Deploy the Application
-------------------------

1. Open a command line and navigate to the root directory of this quickstart.
2. Type this command to build and deploy the archive:

        mvn spring-boot:run

3. This will deploy the application to the instance of the server.


Access the application 
---------------------
 
The application will be running at the following URL: <http://localhost:8080/topics/>.
Swager2 API documentation at the following URL: <http://localhost:8080/swagger-ui.html>



DB setup for the Application
------------------------------------

 The application was developed with MySQL as target DB. 
 The DDL files can be found under /src/main/resources.
 Entity to DTO mapping is handled by Dozer.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc

