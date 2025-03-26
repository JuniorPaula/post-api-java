package com.junior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.demo.domain.User;
import com.junior.demo.dto.UserDTO;
import com.junior.demo.repository.UserRepository;
import com.junior.demo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    User user = userRepository.findById(id).orElse(null);
    if (user == null) {
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
    return user;
  }

  public User insert(User obj) {
    return userRepository.insert(obj);
  }

  public User update(User obj) {
    User newObj = findById(obj.getId());
    updateData(newObj, obj);
    return userRepository.save(newObj);
  }

  private void updateData(User newObj, User obj) {
    newObj.setName(obj.getName());
    newObj.setEmail(obj.getEmail());
  }

  public Void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
    return null;
  }

  public User fromDTO(UserDTO obj) {
    return new User(obj.getId(), obj.getName(), obj.getEmail());
  }
}
