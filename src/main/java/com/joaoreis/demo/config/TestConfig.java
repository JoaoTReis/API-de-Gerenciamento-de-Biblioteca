package com.joaoreis.demo.config;

import com.joaoreis.demo.entities.*;
import com.joaoreis.demo.entities.enums.Literary_genre;
import com.joaoreis.demo.entities.enums.RentStatus;
import com.joaoreis.demo.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RentItemRepository rentItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "988888888", "maria@gmail.com", "rua 5, cidade baixa","12345");
        User u2 = new User(null, "Alex Green", "977777777", "alex@gmail.com", "rua 3, cidade alta","54321");

        Rent o1 = new Rent(null, Instant.parse("2019-06-20T19:53:07Z"), RentStatus.RESERVED, u1);
        Rent o2 = new Rent(null, Instant.parse("2019-07-21T03:42:10Z"),RentStatus.CANCELLED, u2);
        Rent o3 = new Rent(null, Instant.parse("2019-07-22T15:21:22Z"),RentStatus.DAMAGED, u1);

        Category cat1 = new Category(null, Literary_genre.FANTASY);
        Category cat2 = new Category(null, Literary_genre.DRAMA);
        Category cat3 = new Category(null, Literary_genre.ACTION);

        Book p1 = new Book(null, "The Lord of the Rings", "J. R. R. Tolkien", "Lorem ipsum dolor sit amet, consectetur.", "");
        Book p2 = new Book(null, "Dom Quixote", "Miguel de Cervantes", "Nulla eu imperdiet purus. Maecenas ante.", "");
        Book p3 = new Book(null, "Hamlet", "William Shakespeare", "Nam eleifend maximus tortor, at mollis.", "");
        Book p4 = new Book(null, "Sagarana", "Guimarães Rosa", "Donec aliquet odio ac rhoncus cursus.", "");
        Book p5 = new Book(null, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Cras fringilla convallis sem vel faucibus.", "");

        userRepository.saveAll(Arrays.asList(u1,u2));
        rentRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        bookRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        bookRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        RentItem oi1 = new RentItem(o1, p1, o1.getRentStatus());
        RentItem oi2 = new RentItem(o1, p2, o1.getRentStatus());
        RentItem oi3 = new RentItem(o2, p3, o2.getRentStatus());
        RentItem oi4 = new RentItem(o3, p5, o3.getRentStatus());
        
        rentItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),o1);
        o1.setPayment(pay1);

        rentRepository.save(o1);
    }


}
