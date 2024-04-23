package bitlab.to2024g1restcontroller.dto;

import bitlab.to2024g1restcontroller.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

  private String name;
  private String description;
  private Double price;
  private String countryCode;
}
