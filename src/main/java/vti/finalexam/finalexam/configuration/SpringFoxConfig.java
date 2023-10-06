package vti.finalexam.finalexam.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Application API",
                "This is API description for Application,",
                "1.0",
                "Terms of service URL",
                new Contact("VTI Academy", "https://www.facebook.com/VTIAcademy/", "info@vtiacademy.edu.vn"),
                "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList());
    }
    //localhost:9090/swagger-ui/
}
