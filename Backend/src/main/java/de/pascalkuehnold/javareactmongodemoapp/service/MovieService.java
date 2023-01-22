package de.pascalkuehnold.javareactmongodemoapp.service;

import de.pascalkuehnold.javareactmongodemoapp.entity.Movie;
import de.pascalkuehnold.javareactmongodemoapp.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> movieById(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);

    }
}
