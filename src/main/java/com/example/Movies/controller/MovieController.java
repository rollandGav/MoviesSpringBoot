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

    @PutMapping("/{title}/watch")
    public ResponseEntity<Movie> watchMovie(@PathVariable String title){
        return service.markWatched(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{title}/unWatch")
    public ResponseEntity<Movie> unWatchMovie(@PathVariable String title){
        return service.markUnWatched(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{title}/rating/{rating}")
    public ResponseEntity<Movie> patchRating (@PathVariable String title, @PathVariable Double rating){
        return service.updateRating(title, rating)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{title}/rating")
    public ResponseEntity<Movie> patchRating2 (@PathVariable String title, @RequestParam Double rating){
        return service.updateRating(title, rating)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{title}")
    public ResponseEntity<Movie> replaceMovie (@PathVariable String title, @RequestBody Movie movie){
        return service.updateMovie(title,movie)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
