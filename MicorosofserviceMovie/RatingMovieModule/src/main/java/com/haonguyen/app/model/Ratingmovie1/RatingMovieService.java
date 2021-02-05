package com.haonguyen.app.model.Ratingmovie1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingMovieService {
    public RatingMovieService(){
    }

    @Autowired
   private RatingMovieRepository ratingMovieRepository;

    public List<RatingMovie1> findRatingByIdUser(Long idUser){
        return ratingMovieRepository.findByIdUser(idUser);
    }
}
