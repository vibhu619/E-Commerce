package com.EcommerceMarketplace.Service;

import com.EcommerceMarketplace.Dto.ReviewDto;
import com.EcommerceMarketplace.Entity.ProductEntity;
import com.EcommerceMarketplace.Entity.ReviewEntity;
import com.EcommerceMarketplace.Repository.ProductRepository;
import com.EcommerceMarketplace.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<String> addReview(ReviewEntity review) {
        reviewRepository.save(review);
        List<ReviewEntity> reviews=reviewRepository.findByProductId(review.getProductId()).orElseThrow();
        double averageRating=reviews.stream()
                .map(ReviewEntity::getRating)
                .mapToDouble(Double::doubleValue)
                .sum()/reviews.size();
        ProductEntity product=productRepository.findById(review.getProductId()).orElseThrow();
        product.setRating(product.getRating() == null ? review.getRating() : averageRating);
        productRepository.save(product);
        return new ResponseEntity<>("Review posted", HttpStatus.OK);
    }

    public ResponseEntity<List<ReviewDto>> getReviewByProduct(Integer productId) {
        List<ReviewEntity> reviews=reviewRepository.findByProductId(productId).orElseThrow();

        List<ReviewDto> reviewDtos=reviews.stream()
                .map(this::getReviewDtos)
                .toList();

        return new ResponseEntity<>(reviewDtos,HttpStatus.OK);
    }

    private ReviewDto getReviewDtos(ReviewEntity review) {
        return ReviewDto.builder()
                .rating(review.getRating())
                .comments(review.getComment())
                .reviewDate(getReviewDate(review) +" Months ago")
                .build();
    }

    private long getReviewDate(ReviewEntity review) {
        //LocalDate givenDate = LocalDate.parse((CharSequence) review.getReviewDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate currentDate = LocalDate.now();
        Instant instant = review.getReviewDate().toInstant();
        LocalDate givenDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.MONTHS.between(givenDate,currentDate);

    }
}
