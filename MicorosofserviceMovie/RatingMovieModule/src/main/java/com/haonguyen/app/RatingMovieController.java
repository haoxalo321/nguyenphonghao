package com.haonguyen.app;

import com.haonguyen.app.model.Ratingmovie1.RatingMovie1;
import com.haonguyen.app.model.Ratingmovie1.RatingMovieRepository;
import com.haonguyen.app.model.Ratingmovie1.RatingMovieService;
import com.haonguyen.app.model.Ratingmovie1.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingMovieController {
    @Autowired
    private RatingMovieService ratingMovieService;
    @Autowired
    private RatingMovieRepository ratingMovieRepository;

    @GetMapping("/get")
    public ResponseEntity getAllRating(){
        return ResponseEntity.ok().body(ratingMovieRepository.findAll());
    }

//    @RequestMapping("/movie/{idMovie}")
//    public RatingMovie1 getRatingByIdMovie(@PathVariable(name = "idMovie", required = false)String idMovie){
//        UserRating userRating = restTemplate.getForObject("http://rating-movie-service/api/rating/user/1",UserRating.class);
//        System.out.println(userRating);
//        return ratingMovieRepository.findByIdMovie(Long.parseLong(idMovie));
//    }



    @RequestMapping("/user/{idUser}")
    public UserRating getRatingByIdUser(@PathVariable(name = "idUser", required = false)String idUser){
        System.out.println(idUser);
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratingMovieService.findRatingByIdUser(Long.parseLong(idUser)));
        System.out.println(userRating);
        return userRating;
    }

}
