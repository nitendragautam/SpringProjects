package com.nitendratech.movieinfoservice.resources;


import com.nitendratech.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Add an API to movie-info-service at /movies/{movieId} that returns  a hard coded movie information
 */


@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{moviesId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        return new Movie(movieId,"Test Name");

    }
}


