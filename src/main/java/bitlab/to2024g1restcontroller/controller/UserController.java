package bitlab.to2024g1restcontroller.controller;

import bitlab.to2024g1restcontroller.dto.UserCreate;
import bitlab.to2024g1restcontroller.dto.UserUpdate;
import bitlab.to2024g1restcontroller.dto.UserView;
import bitlab.to2024g1restcontroller.entity.User;
import bitlab.to2024g1restcontroller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("{id}")
  public UserView getUser(@PathVariable Long id) {
    return userService.getById(id);
  }

  @PostMapping
  public UserView createUser(@RequestBody UserCreate userCreate) {
    return userService.create(userCreate);
  }

  @PutMapping
  public User updateUser(@RequestBody UserUpdate userUpdate) {
    return null;
  }
}
