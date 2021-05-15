package pl.sda.spring.securitytraining.user;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserRequest {

    private String username;
    private String password;
}
