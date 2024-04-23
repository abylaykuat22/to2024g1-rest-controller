package bitlab.to2024g1restcontroller.service;

import bitlab.to2024g1restcontroller.dto.UserCreate;
import bitlab.to2024g1restcontroller.dto.UserUpdate;
import bitlab.to2024g1restcontroller.dto.UserView;
import bitlab.to2024g1restcontroller.entity.Country;
import bitlab.to2024g1restcontroller.entity.User;
import bitlab.to2024g1restcontroller.mapper.UserMapper;
import bitlab.to2024g1restcontroller.repository.CountryRepository;
import bitlab.to2024g1restcontroller.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final CountryRepository countryRepository;

  public UserView getById(Long id) {
    User user = userRepository.findById(id).orElseThrow();
    UserView userView = UserMapper.INSTANCE.toView(user);
    return userView;
  }

  public UserView create(UserCreate userCreate) {
    Optional<User> optionalUser = userRepository.findByEmail(userCreate.getEmail());
    if (optionalUser.isPresent()) {
      throw new RuntimeException("Email is busy!");
    }

    if (!userCreate.getPassword().equals(userCreate.getRePassword())) {
      throw new RuntimeException("Passwords are not same!");
    }

    User user = UserMapper.INSTANCE.toEntity(userCreate, countryRepository);

    User saved = userRepository.save(user);
    return UserMapper.INSTANCE.toView(saved);
  }
}
