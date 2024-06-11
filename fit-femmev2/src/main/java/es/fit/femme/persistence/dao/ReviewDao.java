package es.fit.femme.persistence.dao;

import es.fit.femme.model.entities.Review;
import es.fit.femme.persistence.dao.interfaces.IReviewDao;
import es.fit.femme.persistence.repositories.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ReviewDao implements IReviewDao {
    IReviewRepository reviewRepository;

    @Autowired
    public void setReviewRepository(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllObjects() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void saveObject(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteObject(Long id) {
        reviewRepository.deleteById(id);
    }
}
