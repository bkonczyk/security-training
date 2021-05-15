package pl.sda.spring.securitytraining.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/create")
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody CreateUserRequest request) {
        service.createUser(request);
    }
}
