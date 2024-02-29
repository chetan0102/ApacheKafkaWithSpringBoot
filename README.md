# SpringBootAPI




**MYSQL**

**application.properties**


spring.datasource.url=jdbc:mysql://localhost:3306/springbootproject
spring.datasource.username=root
spring.datasource.password=Mysql@1234

**Table Name**

CREATE TABLE tbl_employee
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    gender VARCHAR(255),
    department VARCHAR(255),
    dob DATE
);
