package com.mehmetyilmaz.issuemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@Configuration  // uygulama ilk yuklenirken bu dosya yüklenecek ve üzerindeki konfigurasyonlar
                // springin  starter tarafinda devreye alinacak
@EnableSwagger2 // swagger i devreye aldik. api mizi dokumantasyon yapabilmek icin kullaniyoruz swagger i.
public class SwaggerConfig {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "License. This is a open source project for who wants to learn how to develop full-stack api.";
    private static final String title = "Issue Management API Reference";
    private static final String description = "RESTful API Documentation for Springular";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mehmetyilmaz"))
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }


}
