package com.haonguyen.app.MovieInfoService;

import com.haonguyen.app.MovieInfoService.Model.movie.Movie;
import com.haonguyen.app.MovieInfoService.Model.movie.MovieRepository;
import com.haonguyen.app.MovieInfoService.Model.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class    MovieInfoController {
    @Autowired
   private MovieService movieService;
    @Autowired
   private MovieRepository movieRepository;


    @RequestMapping("/get/users/{idUser}")
    public List<Movie> getAllMovie(@PathVariable(name = "idUser", required = false)String idUser){

        return  movieRepository.findAll();
    }

        @PostMapping("/post")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return ResponseEntity.ok().body(movie);
    }

    @RequestMapping("/{idMovie}")
    public Movie getMovieById(@PathVariable(name = "idMovie", required = false) String idMovie){
        return movieService.findMovieById(Long.parseLong(idMovie));
    }

}
