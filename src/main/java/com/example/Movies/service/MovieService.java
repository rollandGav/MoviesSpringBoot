package com.example.Movies.service;

import com.example.Movies.model.Movie;
import com.example.Movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Optional<Movie> findByTitle(String title){
        return repository.findByTitle(title);
    }

    public Movie save(Movie movie){
        return repository.save(movie);
    }

    public void delete(String title){
        repository.delete(title);
    }
}
