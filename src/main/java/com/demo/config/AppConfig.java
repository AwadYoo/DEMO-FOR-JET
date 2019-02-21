package com.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
@EnableAsync
@EnableCaching
@EnableScheduling
public class AppConfig implements WebMvcConfigurer {


//    @Bean(destroyMethod = "shutdown")
//    public HazelcastInstance hazelcastInstance() {
//
//        Config config = new Config();
//        config.setInstanceName("hazelcast-instance")
//                .setGroupConfig(config.getGroupConfig()
//                        .setName("dev")
//                        .setPassword("dev-pass"));
//        return Hazelcast.newHazelcastInstance(config);
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/").addResourceLocations("classpath:/templates/");
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("cacheName");
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jet.cloud.deepmind.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("yhy REST API")
                .description("jet term")
                .version("1.0.0")
                .license("1.23.3.license")
                //.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("yhy", "http://www.10086.com.cn", "yhy@163.com"))
                .build();
    }
}
