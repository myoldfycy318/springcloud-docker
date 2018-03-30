package springcloud.fallbackfactory;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import springcloud.domain.User;
import springcloud.service.UserFeignClient;

import java.util.Map;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {

                logger.info("回退异常", throwable);
                User user = new User();
                user.setId(-3L);
                user.setName("异常回退");
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
        };
    }
}
