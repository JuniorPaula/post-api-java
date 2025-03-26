package com.junior.demo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post implements  Serializable{

  private static final long serialVersionUID = 1L;

  private String id;
  private Date date;
  private String title;
  private String body;

  private User author;

  public Post() {
  }

  public Post(String id, Date date, String title, String body, User author) {
    this.id = id;
    this.date = date;
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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
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

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Post other = (Post) obj;
    return !((this.id == null) ? (other.id != null) : !this.id.equals(other.id));
  }
}
