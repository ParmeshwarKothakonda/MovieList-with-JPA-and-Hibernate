package com.example.movie.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

@RestController 
public class MovieController{

    @Autowired 
    private MovieJpaService movieJpaService;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies(){
        return movieJpaService.getMovies();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return movieJpaService.addMovie(movie);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId){
        return movieJpaService.getMovieById(movieId);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie movie){
        return movieJpaService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        movieJpaService.deleteMovie(movieId);
    }
}