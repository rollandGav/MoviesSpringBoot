package com.example.Movies.controller;

import com.example.Movies.model.Movie;
import com.example.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title){
        return service.findByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(service.save(movie));
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String title){
        service.delete(title);
        return ResponseEntity.noContent().build();
    }
}
