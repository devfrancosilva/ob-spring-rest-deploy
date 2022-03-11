package com.example.obspringrest2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiDetails(){
        return new ApiInfo("OB Spring Api REST",

                "CRUD de libros",
                "1.0",
                "Para uso de practicas java y spring",
                new Contact("Francoder", "www.pandasoft.com.ar", "francoder.web@gmail.com"),
                "MIT",
                "licence.com",
                new ArrayList<>()
                );
    }

}
