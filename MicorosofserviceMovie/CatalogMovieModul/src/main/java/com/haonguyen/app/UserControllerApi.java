package com.haonguyen.app;

import com.haonguyen.app.model.Catalogitem.Catalogitem;
import com.haonguyen.app.model.Movie.Movie;
import com.haonguyen.app.model.Movie.MovieRepository;
import com.haonguyen.app.model.RatingMovie1.RatingMovieRepository;
import com.haonguyen.app.model.RatingMovie1.UserRating;
import com.haonguyen.app.model.User.User;
import com.haonguyen.app.model.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catalog")
public class UserControllerApi {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RatingMovieRepository ratingMovieRepository;
    @Autowired
    private WebClient.Builder getwebClientBuilder;

    @RequestMapping("/{iduser}")
    public List<Catalogitem> getCatalogByidUser(@PathVariable(name = "iduser", required = false) String iduser){
        User user= userRepository.findById(Long.parseLong(iduser)).get();
        UserRating userRating = restTemplate.getForObject("http://rating-movie-service/api/rating/user/"+ iduser,UserRating.class);
//          UserRating userRating = getwebClientBuilder.build()
//                  .get()
//                  .uri("http://localhost:8172/api/rating/user/"+ iduser)
//                  .retrieve()
//                  .bodyToMono(UserRating.class)
//                  .block();
//        System.out.println(userRating);
      return userRating.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/api/movie/"+ rating.getIdMovie(),Movie.class);
//          Movie movie=  getwebClientBuilder.build()
//          .get()
//          .uri("http://localhost:8283/api/movie/")
//          .retrieve()
//          .bodyToMono(Movie.class)
//          .block();
//          System.out.println(movie);
           return new Catalogitem(rating.getIdRating(),user.getIdUser(),movie.getIdMovie(),movie.getMovieName(), rating.getRating());
        }).collect(Collectors.toList());

    }



}
