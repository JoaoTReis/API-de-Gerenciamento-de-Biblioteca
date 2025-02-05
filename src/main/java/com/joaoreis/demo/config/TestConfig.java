package com.joaoreis.demo.config;

import com.joaoreis.demo.entities.Rent;
import com.joaoreis.demo.entities.User;
import com.joaoreis.demo.repositories.RentRepository;
import com.joaoreis.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "rua 5, cidade baixa","12345");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "rua 3, cidade alta","54321");

        Rent o1 = new Rent(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Rent o2 = new Rent(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Rent o3 = new Rent(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        rentRepository.saveAll(Arrays.asList(o1,o2,o3));
    }


}
