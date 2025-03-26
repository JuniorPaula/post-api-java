package com.junior.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.junior.demo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
