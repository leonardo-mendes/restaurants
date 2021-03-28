package com.restaurant.searcher.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc
import java.util.*


@Configuration
@EnableSwagger2WebMvc
class SwaggerConfig {

    @Bean
    fun api(): Docket =
        Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.restaurant.searcher"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())

    private fun apiInfo(): ApiInfo =
        ApiInfo(
            "Find your restaurant",
            "Simple application to find the best match for your order.",
            "1.0.0",
            "Terms of service Url",
            Contact("Leonardo Mendes", "https://www.linkedin.com/in/leonardocm92/", "leonardocm92@hotmail.com"),
            "License of API",
            "API license URL",
            Collections.emptyList()
        )

}