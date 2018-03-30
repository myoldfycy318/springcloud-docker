package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import config.FeignDisableHystrixConfiguration;
import springcloud.domain.User;

/**
 * 借助Feign的自定义，为指定名称的Feign客户端禁用Hystrix
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignDisableHystrixConfiguration.class)
public interface DisableHystrixFeignClient {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
