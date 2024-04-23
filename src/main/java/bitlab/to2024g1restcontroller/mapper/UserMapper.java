package bitlab.to2024g1restcontroller.mapper;

import bitlab.to2024g1restcontroller.dto.UserCreate;
import bitlab.to2024g1restcontroller.dto.UserView;
import bitlab.to2024g1restcontroller.entity.Country;
import bitlab.to2024g1restcontroller.entity.User;
import bitlab.to2024g1restcontroller.repository.CountryRepository;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "fullname", source = "fullName")
  @Mapping(target = "mark", source = "examPoint", qualifiedByName = "defineMark")
  @Mapping(target = "country", source = "country.name")
  UserView toView(User user);

  @Named("defineMark")
  default String calculateExamPoint(Integer examPoint) {
    if (examPoint == null) {
      return null;
    }

    if (examPoint >= 90) {
      return "A";
    } else if (examPoint >= 75) {
      return "B";
    } else if (examPoint >= 60) {
      return "C";
    } else {
      return "D";
    }
  }

  @Mapping(target = "country", expression = "java(mapToCountry(dto, countryRepository))")
  User toEntity(UserCreate dto, CountryRepository countryRepository);

  default Country mapToCountry(UserCreate dto, CountryRepository countryRepository) {
    return countryRepository.findByCode(dto.getCountryCode()).orElse(null);
  }
}
