package org.k8s.helm.app.controller;

import java.util.List;

import org.k8s.helm.app.entity.User;
import org.k8s.helm.app.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

   private final UserRepository repo;

   public UserController(UserRepository repo) {
      this.repo = repo;
   }

   @GetMapping
   public List<User> getAll() {
      return repo.findAll();
   }

   @PostMapping
   public User create(@RequestBody User user) {
      return repo.save(user);
   }
}

