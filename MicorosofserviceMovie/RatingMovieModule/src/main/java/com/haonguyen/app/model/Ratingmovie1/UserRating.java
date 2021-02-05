package com.haonguyen.app.model.Ratingmovie1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
   @JsonProperty("RatingMovie1")
   private List<RatingMovie1> UserRating;
}
