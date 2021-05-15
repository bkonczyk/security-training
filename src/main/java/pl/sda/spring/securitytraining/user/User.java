package pl.sda.spring.securitytraining.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "users")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class User {

    @Id
    @Column(unique = true)
    private String username;

    private String password;

    private String role;
}
