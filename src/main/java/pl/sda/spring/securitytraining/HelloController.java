package pl.sda.spring.securitytraining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String sayHelloUser() {
        return "Hello dear user";
    }
}
