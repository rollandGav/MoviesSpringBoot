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

    public Optional<Movie> markWatched(String title) {
        Optional<Movie> maybeMovie = repository.findByTitle(title);
        if (maybeMovie.isPresent()){
            Movie m =maybeMovie.get();
            m.setWatched(true);
            repository.save(m);
            return Optional.of(m);
        }
        return Optional.empty();
    }

    public Optional<Movie> markUnWatched(String title) {
        Optional<Movie> maybeMovie = repository.findByTitle(title);
        if (maybeMovie.isPresent()){
            Movie m =maybeMovie.get();
            if (m.isWatched()) {
                m.setWatched(false);
                repository.save(m);
            }
            return Optional.of(m);
        }
        return Optional.empty();
    }

    public Optional<Movie> updateRating(String title, Double rating) {
        Optional<Movie> maybeMovie = repository.findByTitle(title);
        if (maybeMovie.isPresent()){
            Movie m =maybeMovie.get();
            m.setRating(rating);
            repository.save(m);
            return Optional.of(m);
        }
        return Optional.empty();
    }

    public Optional<Movie> updateMovie(String title, Movie movie) {
        Optional<Movie> maybeMovie = repository.findByTitle(title);
        if (maybeMovie.isPresent()){
            Movie m =maybeMovie.get();
            m.setDirector(movie.getDirector());
            m.setReleaseDate(movie.getReleaseDate());
            m.setRating(movie.getRating());
            m.setWatched(movie.isWatched());
            repository.save(m);
            return Optional.of(m);
        }
        return Optional.empty();
    }
}
