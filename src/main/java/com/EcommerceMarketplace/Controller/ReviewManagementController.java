package com.EcommerceMarketplace.Controller;

import com.EcommerceMarketplace.Dto.ReviewDto;
import com.EcommerceMarketplace.Entity.ReviewEntity;
import com.EcommerceMarketplace.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewManagementController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/addReview")
    public ResponseEntity<String> addReview(@RequestBody ReviewEntity review){
        return reviewService.addReview(review);

    }

    @GetMapping("/getReviewForProduct")
    public ResponseEntity<List<ReviewDto>> getReviewByProduct(@RequestParam Integer id){
        return reviewService.getReviewByProduct(id);
    }
}
