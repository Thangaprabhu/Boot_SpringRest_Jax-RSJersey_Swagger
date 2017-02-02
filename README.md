# Java  SpringBoot RESTAPI

1) Spring MVC is an MVC pattern design and it can be used as Rest Services specification.
2) But Spring Rest is not JaxRs compliant.
3) Jersey is JaxRs compliant Rest Service implementation.
4) Most projects uses both "Spring MVC" and "JaxRs compliant". Spring MVC for sending JSPs. Rest Services for AJAX services. Note: CDN can cache Rest Service calls. 
5) Swagger is an specification for Rest API documentation. SpringFox is one implementation of Swagger. Points: We don't to specify any Swagger documentation for the APIs in code base. Swagger can read the method name, method arguments, method comments, request type(GET, POST) and can build the front end.  

How to Use this application:
1) Run the class Boot_SpringRest_JaxRSJersey_SwaggerApplication.java
2) JaxRSRestController has Rest Services sample
3) UserRestController has MVC sample.
4) http://localhost:8080/swagger-ui.html shows the front end for the both Rest and MVC.

Notes: 
http://stackoverflow.com/questions/35966204/how-to-integrate-swagger-with-jersey-spring-boot
http://stackoverflow.com/questions/32877898/springfox-not-finding-jax-rs-endpoints
