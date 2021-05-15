package pl.sda.spring.securitytraining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return "Hello dear admin";
    }

    @GetMapping("/user")
    public String sayHelloUser(Principal principal) {
        return "Hello dear: " + principal.getName();
    }
}
