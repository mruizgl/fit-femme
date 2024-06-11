package es.fit.femme.persistence.dao.interfaces;

import es.fit.femme.model.entities.Producto;
import es.fit.femme.model.entities.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewDao {
    List<Review> getAllObjects();
    Optional<Review> findById(Long id);
    void saveObject(Review review);
    void deleteObject(Long id);
}
