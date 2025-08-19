package com.example.Movies.repository;

import com.example.Movies.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    public List<Movie> findAll(){
        return new ArrayList<>(movies.values());
    }

    public Optional<Movie> findByTitle(String title){
        return Optional.ofNullable(movies.get(title));
    }

    public Movie save(Movie movie){
        movies.put(movie.getTitle(),movie);
        return movie;
    }

    public void delete(String title){
        movies.remove(title);
    }
}
