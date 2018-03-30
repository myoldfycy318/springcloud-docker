package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springcloud.domain.User;
import springcloud.service.DisableHystrixFeignClient;
import springcloud.service.UserFeignClient;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DisableHystrixFeignClient disableHystrixFeignClient;

    @GetMapping("user/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    /**
     * 调用禁用Hystrix的Feign客户端
     * @param id
     * @return
     */
    @GetMapping("usernohystrix/{id}")
    public User findByIdWithoutHystrix(@PathVariable Long id){
        return disableHystrixFeignClient.findById(id);
    }

    @GetMapping("user/get")
    public User get(@RequestParam("id") Long id,@RequestParam("username")String username){
       return userFeignClient.get1(id,username);
    }


    @GetMapping("user/getMap")
    public User getMap(@RequestParam("id") Long id,@RequestParam("username")String username){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        map.put("username",username);
        return userFeignClient.getMap(map);
    }

    @PostMapping("/user/post")
    public User post(User user){
        return userFeignClient.post(user);
    }


}
