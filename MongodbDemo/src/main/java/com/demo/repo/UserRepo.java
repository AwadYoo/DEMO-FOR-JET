package com.demo.repo;

import com.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author awad_yoo
 * @create 2019-04-29 14:05
 */
@Repository
public interface UserRepo extends MongoRepository<User, Long> {
}
