package es.fit.femme.controller;

import es.fit.femme.model.dto.ProductoDTO;
import es.fit.femme.model.dto.ReviewDTO;
import es.fit.femme.model.entities.Producto;
import es.fit.femme.model.entities.Review;
import es.fit.femme.model.mapper.ProductoMapper;
import es.fit.femme.model.mapper.ReviewMapper;
import es.fit.femme.services.interfaces.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    IReviewService reviewService;

    @Autowired
    public void setReviewService(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewService.findById(id);

        if(reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setContenido(review.getContenido());

            return  ResponseEntity.ok(reviewDTO);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<ReviewDTO> reviewDTOS = reviewService.getAllObjects().stream().map(ReviewMapper::toDto).toList();
        return ResponseEntity.ok(reviewDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ReviewDTO reviewDTO) throws URISyntaxException {
        if (reviewDTO.getContenido().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Review review = ReviewMapper.toEntity(reviewDTO);
        reviewService.saveObject(review);

        return ResponseEntity.created( new URI("/producto/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        Optional<Review> reviewOptional = reviewService.findById(id);

        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setContenido(reviewDTO.getContenido());
            reviewService.saveObject(review);

            return  ResponseEntity.ok("Registro actualizado con éxito");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewService.findById(id);
        if (id != null) {
            if(reviewOptional.isPresent()) {
                reviewService.deleteObject(id);
                return ResponseEntity.ok("Registro eliminado con éxito");
            }

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
