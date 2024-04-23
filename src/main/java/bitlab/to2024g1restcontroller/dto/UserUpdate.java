package bitlab.to2024g1restcontroller.dto;

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
public class UserUpdate {

  private Long id;
  private String email;
  private String currentPassword;
  private String newPassword;
  private String reNewPassword;
  private String fullName;
}
