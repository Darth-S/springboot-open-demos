package org.example.security.boot.repo;

import org.example.security.boot.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<UserDto,String> {
    UserDto findByUsername (String username);
}
