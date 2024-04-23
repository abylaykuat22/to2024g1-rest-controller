package bitlab.to2024g1restcontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UserCreate {

  private String email;
  private String password;
  private String rePassword;
  private String fullName;
  private String countryCode;
  @JsonProperty("exam_point")
  private String examPoint;
}
