package com.junior.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.junior.demo.domain.User;
import com.junior.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();

    User u1 = new User(null, "Maria", "maria@email.com");
    User u2 = new User(null, "Bob", "bob@email.com");
    User u3 = new User(null, "Alex", "alex@email.com");

    userRepository.saveAll(Arrays.asList(u1, u2, u3));
  }

}
