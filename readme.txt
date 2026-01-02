start app:
mvn spring-boot:run

swagger:
http://localhost:8080/swagger-ui.html


Flyway:
skal bruges til at lave migration scripts da Hibernate kun er en ORM. ChatGPT har genereret V1__init.sql baseret på
console output fra hibernate create.

Db-Repo-Service pattern:
https://medium.com/@vino7tech/one-to-one-mapping-in-spring-boot-jpa-7b892f89a671