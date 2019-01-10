package org.BookMyShow.Repository;

import org.BookMyShow.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUnameAndUpass(String uname,String upass);
    User findByUname(String uname);
}
