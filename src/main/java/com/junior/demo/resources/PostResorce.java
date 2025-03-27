package com.junior.demo.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.junior.demo.domain.Post;
import com.junior.demo.dto.CommentDTO;
import com.junior.demo.dto.PostDTO;
import com.junior.demo.resources.utils.URL;
import com.junior.demo.services.PostService;


@RestController
@RequestMapping(value = "/posts")
public class PostResorce {

  @Autowired
  private PostService service;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody PostDTO objDTO) {
    Post obj = service.fromDTO(objDTO);
    obj = service.insert(obj);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findAll() {
    List<Post> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@PathVariable String id, @RequestBody PostDTO objDTO) {
    Post obj = service.fromDTO(objDTO);
    obj.setId(id);
    service.update(obj);

    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/{id}/comment", method = RequestMethod.POST)
  public ResponseEntity<Void> addComment(@PathVariable String id, @RequestBody CommentDTO objDTO) {
    service.addComment(id, objDTO);

    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/{id}/comment/{index}", method = RequestMethod.PUT)
  public ResponseEntity<Void> updateComment(
    @PathVariable String id,
    @PathVariable String index,
    @RequestBody CommentDTO objDTO) {
    service.updateComment(id, index, objDTO);

    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/{id}/author/{userId}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> update(@PathVariable String id, @PathVariable String userId) {
    service.delete(id, userId);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/textsearch", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
    text = URL.decodeParam(text);
    List<Post> list = service.findByTitle(text);
    return ResponseEntity.ok().body(list);
  }

  @RequestMapping(value="/fullsearch", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findByTitleOrDate(
    @RequestParam(value="text", defaultValue="") String text,
    @RequestParam(value="minDate", defaultValue="") String minDate,
    @RequestParam(value="maxDate", defaultValue="") String maxDate) {

    text = URL.decodeParam(text);
    Date min = URL.convertDate(minDate, new Date(0L));
    Date max = URL.convertDate(maxDate, new Date());

    List<Post> list = service.findByTitleOrDate(text, min, max);
    return ResponseEntity.ok().body(list);
  }
}
