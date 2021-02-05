package com.haonguyen.app.model.RatingMovie1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingMovie1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRating;

    private Long idUser;
    private Long idMovie;
    private Long rating;
}
