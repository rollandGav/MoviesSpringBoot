package com.example.Movies.component;

import com.example.Movies.model.Movie;
import com.example.Movies.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MovieService service;

    public DataInitializer(MovieService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.save(new Movie("Inception", "Dude", 2010, 9.5,false));
        service.save(new Movie("Dune", "Dude 2", 2023, 8.4,false));
        service.save(new Movie("The GodFather", "Dude 3", 1972, 9.9,false));
    }
}
