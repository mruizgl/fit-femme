package es.fit.femme.persistence.repositories;

import es.fit.femme.model.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends CrudRepository<Review, Long> {
}
