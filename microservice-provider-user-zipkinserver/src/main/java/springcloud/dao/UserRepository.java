package springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcloud.domain.User;

/**
 * UserRepository
 *
 * @author Zhang ShanMin
 * @date 2018/3/24
 * @time 11:17
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
