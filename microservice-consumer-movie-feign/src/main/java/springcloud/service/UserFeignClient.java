package springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springcloud.configuration.FeignLogConfiguration;
import springcloud.domain.User;
import springcloud.fallback.FeignClientFallback;

import java.util.Map;

@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallback.class, configuration = FeignLogConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);


    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    User getMap(@RequestParam Map<String, Object> map);


    @RequestMapping(value = "/user/post", method = RequestMethod.POST)
    User post(@RequestBody User user);

}

