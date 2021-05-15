package pl.sda.spring.securitytraining.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.spring.securitytraining.user.User;
import pl.sda.spring.securitytraining.user.UserService;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findByUsername(username);
        return new UserDetailsAdapter(user);
    }
}
