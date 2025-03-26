package com.junior.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junior.demo.domain.User;
import com.junior.demo.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResorce {

  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findAll() {
    List<User> users = service.findAll();
    return ResponseEntity.ok().body(users);
  }
}
