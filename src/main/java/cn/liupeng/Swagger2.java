package cn.liupeng;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        // 使用token验证机制
        List<SecurityScheme> list = new ArrayList<>();
        list.add(new ApiKey("access_token", "access_token", "query"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.liupeng"))
                .paths(PathSelectors.any())
                .build().securitySchemes(list);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description).termsOfServiceUrl("no terms of service")
                .version(version)
                .build();
    }



}
