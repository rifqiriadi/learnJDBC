package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("staging")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    final String API_TITLE = "Access Cargo API Documentation";
    final String API_DESC = "Awb Report Service";
    final String API_VERSION = "1.0";

    @Bean
    public Docket swagger() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);

        return docket;
    }

    private Predicate<String> paths() {
        return Predicates.and(
                PathSelectors.regex("/.*"),
                Predicates.not(PathSelectors.regex("/error.*"))
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESC)
                .version(API_VERSION)
                .build();
    }
}
