package es.fit.femme.model.mapper;

import es.fit.femme.model.dto.ReviewDTO;
import es.fit.femme.model.entities.Review;

public class ReviewMapper {

    public static Review toEntity (ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setContenido(reviewDTO.getContenido());
        return  review;

    }

    public  static ReviewDTO toDto (Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setContenido(review.getContenido());

        return reviewDTO;
    }
}
