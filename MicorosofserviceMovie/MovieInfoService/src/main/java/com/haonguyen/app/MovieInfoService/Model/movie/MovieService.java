package com.haonguyen.app.MovieInfoService.Model.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    public MovieService(){}
   @Autowired
   private MovieRepository movieRepository;

    public Movie findMovieById(Long id){
        return movieRepository.findById(id).get();
    }
}
