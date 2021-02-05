package com.haonguyen.app.model.RatingMovie1;

import com.haonguyen.app.model.RatingMovie1.RatingMovie1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingMovieRepository extends JpaRepository<RatingMovie1, Long> {
}
