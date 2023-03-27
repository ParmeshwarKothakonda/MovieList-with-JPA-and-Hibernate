package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.MovieJpaRepository;

@Service
public class MovieJpaService implements MovieRepository{

    @Autowired 
    private MovieJpaRepository movieJpaRepository;

    @Override
    public ArrayList<Movie> getMovies(){
        List<Movie> moviesList = movieJpaRepository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(moviesList);

        return movies;

    }

    @Override
    public Movie addMovie(Movie movie){
        try{
            movieJpaRepository.save(movie);
            return movie;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Movie getMovieById(int movieId){
        try{
            Movie requestedMovie = movieJpaRepository.findById(movieId).get();
            return requestedMovie;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    @Override
    public Movie updateMovie(int movieId, Movie movie){
        try{
            Movie existingMovie = movieJpaRepository.findById(movieId).get();

            if(movie.getMovieName() != null){
                existingMovie.setMovieName(movie.getMovieName());
            }

            if(movie.getLeadActor() != null){
                existingMovie.setLeadActor(movie.getLeadActor());
            }

            movieJpaRepository.save(existingMovie);
            return existingMovie;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteMovie(int movieId){
        try{
            movieJpaRepository.deleteById(movieId);

        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


}