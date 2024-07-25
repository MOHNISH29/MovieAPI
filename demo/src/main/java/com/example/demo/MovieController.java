package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies()
    {
        List<Movie> mv = movieService.getAllMovies();
        return new ResponseEntity<List<Movie>>(mv , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable ObjectId id) throws Exception {
        Movie mv = movieService.getMovie(id);
        return new ResponseEntity<Movie>(mv , HttpStatus.OK);
    }

    @GetMapping("/imdb/{id}")
    public ResponseEntity<Optional<Movie>> getMovieImdbId(@PathVariable String id)
    {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieImdb(id) , HttpStatus.OK);
    }

}
