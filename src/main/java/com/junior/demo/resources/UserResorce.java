package com.junior.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junior.demo.domain.User;


@RestController
@RequestMapping(value = "/users")
public class UserResorce {

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findAll() {
    System.out.println("findAll");
    User u = new User("1", "Maria Silva", "maria@email.com");
    User u2 = new User("2", "Bob Brown", "bob@email.com");
    List<User> users = new ArrayList<>();
    
    users.addAll(Arrays.asList(u, u2));
    return ResponseEntity.ok().body(users);
  }
}
