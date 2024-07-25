package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;
    public List<Movie> getAllMovies()
    {
        return movieRepo.findAll();
    }
    public Movie getMovie (ObjectId id) throws Exception {
        Movie mv = movieRepo.findById(id).orElseThrow(()->new MovieNotFoundException());
        return mv;
    }
    public Optional<Movie> getMovieImdb(String imdbId)
    {
        return movieRepo.getMovieByImdbId(imdbId);
    }
}
