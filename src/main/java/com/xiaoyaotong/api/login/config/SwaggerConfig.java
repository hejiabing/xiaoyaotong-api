package com.xiaoyaotong.api.login.config;

public class SwaggerConfig {}
/**
 * swagger-ui的配置
 * @author ScienJus
 * @date 2015/7/10.

@Configuration
@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(new ApiInfo("Spring RESTful Authorization Demo Api",
                        null, null, null, null, null)).
                        //将Timestamp类型全部转为Long类型
                        directModelSubstitute(Timestamp.class, Long.class);
    }

}
 */