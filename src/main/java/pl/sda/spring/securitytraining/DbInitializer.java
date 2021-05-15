package pl.sda.spring.securitytraining;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DbInitializer {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initializeUsers() {
        repository.save(User.of("admin", passwordEncoder.encode("password"), "ROLE_ADMIN"));
        repository.save(User.of("user", passwordEncoder.encode("password"), "ROLE_USER"));
    }
}
