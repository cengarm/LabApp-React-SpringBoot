# LabApp

# Project Installation and Running 

## Requirements:
Tech:
- Maven 
- Java 
- React
- PostgreSQL

For Database:

        spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.hibernate.show-sql=true
        spring.datasource.url=jdbc:postgresql://localhost:5432/Lab   ==> Dont forget change
        spring.datasource.username=postgres
        spring.datasource.password=123456   ==> Dont forget change
        spring.jpa.properties.javax.persistence.validation.mode = none

## Installation
1-Clone this repo 
```sh
git clone https://github.com/cengarm/LabApp.git
```
2-Then navigate to the path where the easylab project is located in the Terminal

cd lab-app
```
3-Create Jar file for the project
```sh
mvn package
```
4-Then go lab-app target folder
```sh
cd target
```

## Running

5-Run Jar project file
```sh
java -jar easylab-0.0.1-SNAPSHOT.jar
```
