
/*  TODO= ESTA CLASE DE LA CONFIGURACION DE SWAGGER SE UTILIZA EN LAS VERSIONES ANTERIORES A LA 3.0.0 DE SPRING BOOT QUE UTILIZAN LA DEPENDENIA SPRINGFOX
    TODO= COMO YO ESTOY UTILIZANDO LA VERSION 3.1.0 UTILIZO LA DEPENDENCIA springdoc-openapi-starter-webmvc-ui Y NO ES NECESARIA ESTA CLASE
    TODO= BASICAMENTO LO QUE HACE ES SCANEAR TODO LO QUE ESTE DENTRO DEL PAQUETE CONTROLLER QUE SE INDICA EN LA RUTA: .apis(RequestHandlerSelectors.basePackage("com.sacavix.todoapp.controller")) ESTA LINEA DE CODIGO ESTA EN EL @Bean PRINCIPAL
    TODO= Y BUSCA TODAS LAS CLASES ANOTADAS CON @RestController PARA RENDERIZAR LOS METODOS Y  DOCUMENTAR LA API QUE HEMOS DESARROLLADO
    TODO= Y EN apiInfo() INDICAS LA INFORMACION DE TU API QUE SE MOSTRARA DESPUES EN EL SWAGGER UI

package com.joel.todoapi.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.joel.todoapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Todo API",
                "La API REST de ToDo App.",
                "v1",
                "Terms of service",
                new Contact("JOEL Tech", "www.example.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
*/