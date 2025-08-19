package com.example.Movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.authenticator.SavedRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String title;
    private String director;
    private int releaseDate;
    private double rating;
}
