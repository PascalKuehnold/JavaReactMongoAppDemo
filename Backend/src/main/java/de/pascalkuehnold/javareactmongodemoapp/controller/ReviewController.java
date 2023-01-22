package de.pascalkuehnold.javareactmongodemoapp.controller;

import de.pascalkuehnold.javareactmongodemoapp.entity.Review;
import de.pascalkuehnold.javareactmongodemoapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(
                reviewService.createReview(
                    payload.get("reviewBody"),
                    payload.get("imdbId")
                ),
                HttpStatus.CREATED);
    }
}
