package com.junior.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.junior.demo.domain.Post;
import com.junior.demo.domain.User;
import com.junior.demo.dto.AuthorDTO;
import com.junior.demo.repository.PostRepository;
import com.junior.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    userRepository.deleteAll();
    postRepository.deleteAll();

    User u1 = new User(null, "Maria", "maria@email.com");
    User u2 = new User(null, "Bob", "bob@email.com");
    User u3 = new User(null, "Alex", "alex@email.com");

    userRepository.saveAll(Arrays.asList(u1, u2, u3));

    Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
    Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

    postRepository.saveAll(Arrays.asList(p1, p2));
  }

}
