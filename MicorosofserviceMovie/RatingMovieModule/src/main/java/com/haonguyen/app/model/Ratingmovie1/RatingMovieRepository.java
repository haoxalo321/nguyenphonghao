package com.haonguyen.app.model.Ratingmovie1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingMovieRepository extends JpaRepository<RatingMovie1, Long> {

   RatingMovie1 findByIdMovie(Long id);
   @Query("select rt from rating")
   List<RatingMovie1> findByIdUserQuery(Long id);
}
