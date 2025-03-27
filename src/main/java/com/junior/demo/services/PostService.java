package com.junior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.demo.domain.Post;
import com.junior.demo.repository.PostRepository;
import com.junior.demo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository PostRepository;

  public Post findById(String id) {
    Post Post = PostRepository.findById(id).orElse(null);
    if (Post == null) {
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
    return Post;
  }

  public List<Post> findByTitle(String text) {
    return PostRepository.findByTitle(text);
  }
}
