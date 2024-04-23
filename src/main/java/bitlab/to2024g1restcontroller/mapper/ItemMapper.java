package bitlab.to2024g1restcontroller.mapper;

import bitlab.to2024g1restcontroller.dto.ItemDto;
import bitlab.to2024g1restcontroller.entity.Country;
import bitlab.to2024g1restcontroller.entity.Item;
import bitlab.to2024g1restcontroller.repository.CountryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
  ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

  @Mapping(target = "country", expression = "java(mapToCountry(dto, countryRepository))")
  Item toEntity(ItemDto dto, CountryRepository countryRepository);

  default Country mapToCountry(ItemDto dto, CountryRepository countryRepository) {
    return countryRepository.findByCode(dto.getCountryCode()).orElse(null);
  }
}
