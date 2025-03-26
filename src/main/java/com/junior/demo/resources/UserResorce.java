package com.junior.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junior.demo.domain.User;
import com.junior.demo.dto.UserDTO;
import com.junior.demo.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResorce {

  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> users = service.findAll();
    List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }
}
