package com.haonguyen.app.model.Catalogitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalogitem {

    private Long idRating;
    private Long idUser;
    private Long idMovie;
    private String movieName;
    private Long rating;
}
