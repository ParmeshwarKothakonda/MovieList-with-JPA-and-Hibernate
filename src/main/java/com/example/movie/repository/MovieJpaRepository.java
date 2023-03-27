package com.example.movie.repository;

import org.springframework.stereotype.Repository;
import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie,Integer>{

}