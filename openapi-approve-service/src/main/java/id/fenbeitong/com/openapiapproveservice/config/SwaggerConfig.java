package id.fenbeitong.com.openapiapproveservice.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * <p>Swagger General Config
 *
 * @author Created by ivan on 上午11:52 18-11-8.
 * @version 1.0
 **/
@SpringBootConfiguration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * @return springfox.documentation.spring.web.plugins.Docket
     * @author Created by ivan on 上午11:53 18-11-8.
     * <p>create Rest Api
     **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("id.fenbeitong.com.openapiapproveservice.api"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @return springfox.documentation.service.ApiInfo
     * @author Created by ivan on 上午11:53 18-11-8.
     * <p>api common Info
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API with Swagger 2")
                .description("Swagger 2 for Spring Could/Boot")
                .contact(new Contact("Open-api", "", ""))
                .version("1.0")
                .build();
    }
}
