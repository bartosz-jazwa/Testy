package com.jazwa.testy;

import com.jazwa.testy.model.User;
import com.jazwa.testy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class TestyApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("user","user","USER");
        User admin = new User("admin", "admin", "ADMIN");

        userRepository.save(user);
        userRepository.save(admin);
    }
}
