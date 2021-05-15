package pl.sda.spring.securitytraining;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "users")
public class User {

    @Id
    private String username;

    private String password;

    private String role;
}
