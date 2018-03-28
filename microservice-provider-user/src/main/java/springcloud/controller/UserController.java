package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springcloud.dao.UserRepository;
import springcloud.domain.User;

import java.util.Optional;

/**
 * UserController
 *
 * @author Zhang ShanMin
 * @date 2018/3/24
 * @time 11:13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }


    @GetMapping("/get")
    public User get(User user) {
        return user;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

}

