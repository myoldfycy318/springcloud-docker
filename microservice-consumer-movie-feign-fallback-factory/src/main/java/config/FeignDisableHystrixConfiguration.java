package config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 如果需要自定义单个Feign配置，Feign的@Configuration 注解的类不能与@ComponentScan 的包重叠
 如果包重叠，将会导致所有的Feign Client都会使用该配置。
 */
@Component
public class FeignDisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
