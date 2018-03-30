package springcloud.fallback;

import org.springframework.stereotype.Component;
import springcloud.domain.User;
import springcloud.service.UserFeignClient;

import java.util.Map;

/**
 * 回退类FeignClientFallback需要实现FeignClient接口
 */
@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-2L);
        user.setName("默认名 -2");
        return user;
    }

    @Override
    public User get1(Long id, String username) {
        return null;
    }

    @Override
    public User getMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public User post(User user) {
        return null;
    }
}
