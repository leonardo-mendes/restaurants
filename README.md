# Restaurant Challenge [![Build Status](https://travis-ci.org/leonardo-mendes/restaurants.svg?branch=master)](https://travis-ci.org/leonardo-mendes/restaurants) [![codecov](https://codecov.io/gh/leonardo-mendes/restaurants/branch/master/graph/badge.svg?token=MTP9VDFF0K)](https://codecov.io/gh/leonardo-mendes/restaurants)

### About

This is a simple application to find the best restaurant for your order.

### Running the application

Open your terminal and run:
```
make start
```

### Running the application tests

Open your terminal and run:
```
make run test
```

### Local Swagger 
``http://localhost:9090/swagger-ui.html``

```
FindRestaurantRequest {
    name: String -> Restaurant's name
    customerRating: Int -> Restaurant's rating (1-5)
    distance: Int -> Restaurant's distance (1-10)
    price: Int -> Restaurant's price (10-50)
    cuisine: String -> Restaurant's cuisine    
}
```
<br/>

#### Used Tools

[Spring Boot](https://spring.io/projects/spring-boot) - [Kotlin](https://kotlinlang.org/) - [Gradle](https://docs.gradle.org) - [Swagger](https://swagger.io/) - [OpenCSV](http://opencsv.sourceforge.net/) - [Junit](https://junit.org/junit5/) - [Travis-CI](https://travis-ci.org/) - [Codecov](https://about.codecov.io/)

