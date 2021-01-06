package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class Service5Application {

	public static void main(String[] args) {
		SpringApplication.run(Service5Application.class, args);
	}

	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Service5")
            .description("Here You will get all Controllers and Model Methods")
            
            //.license("Apache 2.0")
            //.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            
            .build();
    }
 @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            //.apis(RequestHandlerSelectors.basePackage("com.mypackage.api"))
            .build()
            .apiInfo(apiInfo());
    }
}


