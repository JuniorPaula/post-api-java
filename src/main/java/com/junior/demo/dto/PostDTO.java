package com.junior.demo.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String title;
  private String body;
  private AuthorDTO author;
  
  public PostDTO() {
  }
  
  public PostDTO(String id, String title, String body, AuthorDTO author) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.author = author;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getBody() {
    return body;
  }
  
  public void setBody(String body) {
    this.body = body;
  }
  
  public AuthorDTO getAuthor() {
    return author;
  }
  
  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }
}
