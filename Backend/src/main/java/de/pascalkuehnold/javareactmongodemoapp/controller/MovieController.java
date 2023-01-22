package de.pascalkuehnold.javareactmongodemoapp.controller;

import de.pascalkuehnold.javareactmongodemoapp.entity.Movie;
import de.pascalkuehnold.javareactmongodemoapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = {"imdbId"}
    )
    public ResponseEntity<Optional<Movie>> getMovieById(@RequestParam("imdbId") String imdbId){
        return new ResponseEntity<>(movieService.movieById(imdbId), HttpStatus.OK);
    }

}
