package com.mengcc.ms.adminuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhouzq
 * @date 2019/8/28
 * @desc
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket: Springfox’s, primary api configuration mechanism is initialized for swagger specification 2.0
     *
     * A builder which is intended to be the primary interface into the swagger-springmvc framework.
     * Provides sensible defaults and convenience methods for configuration.
     * @return
     */
    @Bean
    public Docket mengccAdminUserApiDoc() {
        // see https://springfox.github.io/springfox/docs/current/
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("1.mengcc后台接口API")
                .apiInfo(mengccAdminUserInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mengcc.ms.adminuser.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo mengccAdminUserInfo() {
        return new ApiInfoBuilder()
                .title("mengcc系统adminuser-api REST API文档")
                .description("提供给后台用户的api接口，由网关进行路由。\n"
                        + "本文档由 [springfox-swagger2](http://springfox.github.io/springfox/) 自动生成。\n\n")
                // .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("", "www.mengcc.cn", "bestzhouzq@gmail.com"))
                .version("1.0")
                .build();
    }




}
