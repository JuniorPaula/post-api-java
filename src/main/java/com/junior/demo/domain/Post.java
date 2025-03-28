package com.junior.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.junior.demo.dto.AuthorDTO;
import com.junior.demo.dto.CommentDTO;

@Document(collection = "posts")
public class Post implements  Serializable{

  private static final long serialVersionUID = 1L;

  private String id;
  private Date date;
  private String title;
  private String body;

  private AuthorDTO author;

  private List<CommentDTO> comments = new ArrayList<>();

  public Post() {
  }

  public Post(String id, Date date, String title, String body, AuthorDTO author) {
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

  public AuthorDTO getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }

  public List<CommentDTO> getComments() {
    return comments;
  }

  public void setComments(List<CommentDTO> comments) {
    this.comments = comments;
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

  @Override
  public String toString() {
    return "Post{" + "id=" + id + ", date=" + date + ", title=" + title + ", body=" + body + ", author=" + author + ", comments=" + comments + '}';
  }
}
