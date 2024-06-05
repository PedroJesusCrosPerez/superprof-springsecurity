package app.superprof.content.user.infrastructure.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

	@NotBlank
  	private String username;

	@NotBlank
	private String password;
}
