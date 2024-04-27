package com.javatechie;

import com.javatechie.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class UserServiceApplication {

    @GetMapping("/greetings")
    public String greetings() {
        return "Congratulations!! You've successfully deployed your first application in the Kubernetes cluster!";
    }

    @GetMapping("/users")
    public List<User> loadUsers() {
        return Stream.of(new User(1, "Basant", "basant@gmail.com"),
                new User(2, "Shiva", "shiva@gmail.com"),
                new User(3, "Saurabh", "saurabh@gmail.com"),
                new User(4, "Preeti", "preeti@gmail.com")
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
