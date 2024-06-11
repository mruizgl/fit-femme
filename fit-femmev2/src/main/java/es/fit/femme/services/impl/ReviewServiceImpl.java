package es.fit.femme.services.impl;

import es.fit.femme.model.entities.Producto;
import es.fit.femme.model.entities.Review;
import es.fit.femme.persistence.dao.interfaces.IReviewDao;
import es.fit.femme.services.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewServiceImpl implements IReviewService {
    private IReviewDao reviewDao;

    @Autowired
    public void setReviewDao(IReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }


    @Override
    public List<Review> getAllObjects() {
        return reviewDao.getAllObjects();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewDao.findById(id);
    }

    @Override
    public void saveObject(Review review) {
        reviewDao.saveObject(review);
    }

    @Override
    public void deleteObject(Long id) {
        reviewDao.deleteObject(id);
    }
}
