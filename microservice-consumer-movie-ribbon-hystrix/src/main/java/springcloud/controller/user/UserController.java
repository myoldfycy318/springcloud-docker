package springcloud.controller.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.domain.User;


@RestController
@RequestMapping("/user")
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/id/{id}")
    public User findById4ribbon(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user" + "/user/" + id, User.class);
    }


    public User findByIdFallback(Long id){
        User user = new User();
        user.setId( -1L);
        user.setName("默认用户");
        return user;
    }


    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        logger.info("{}--{}--{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
