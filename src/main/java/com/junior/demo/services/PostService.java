package com.junior.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.demo.domain.Post;
import com.junior.demo.dto.PostDTO;
import com.junior.demo.repository.PostRepository;
import com.junior.demo.services.exceptions.ForbiddenException;
import com.junior.demo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository PostRepository;

  public Post insert(Post obj) {
    return PostRepository.insert(obj);
  }

  public List<Post> findAll() {
    return PostRepository.findAll();
  }

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

  public List<Post> findByTitleOrDate(String text, Date minDate, Date maxDate) {
    maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
    return PostRepository.findByTitleOrDate(text, minDate, maxDate);
  }

  public Post update(Post obj) {
    Post newObj = findById(obj.getId());
    if (!newObj.getAuthor().getId().equals(obj.getAuthor().getId())) {
      throw new ForbiddenException("Usuário não autorizado");
    }

    newObj.setTitle(obj.getTitle() != null ? obj.getTitle() : newObj.getTitle());
    newObj.setBody(obj.getBody() != null ? obj.getBody() : newObj.getBody());
    newObj.setAuthor(obj.getAuthor() != null ? obj.getAuthor() : newObj.getAuthor());

    return PostRepository.save(newObj);
  }

  public Post fromDTO(PostDTO obj) {
    return new Post(obj.getId(), new Date(), obj.getTitle(), obj.getBody(), obj.getAuthor());
  }
}
