package com.ibm.fullstack.config;

import io.swagger.annotations.ApiOperation;
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

@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 扫描注解了@ApiOperation的方法生成API接口文
     * @return
     */
    @Bean
    public Docket RestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("rest")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 扫描controller包生成API接口文档
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ibm.fullstack.controller"))//扫描的包名
                .paths(PathSelectors.any())
                .build();
    }

     /**
      * Docket 对象
      * @return
      */
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("SpringBoot利用swagger构建api文档")
                 .description("Rest风格的Api文档")
                 .termsOfServiceUrl("").contact(new Contact("Abbot", "www.baidu.com", "cmingwh@cn.ibm.com"))
                 .version("1.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                 .build();
     }
}
