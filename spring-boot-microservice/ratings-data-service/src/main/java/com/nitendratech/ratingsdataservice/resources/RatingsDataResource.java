package com.nitendratech.ratingsdataservice.resources;

/**
 * Created by @author nitendratech on 5/5/20
 */

import com.nitendratech.ratingsdataservice.domain.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creating an Hardcoded API in ratings-data-service to return a rating given a
 * movie ID: /ratingsdata/{movieId}
 */


@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {


    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){

    return new Rating(movieId, 4);
}

}
