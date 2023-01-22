package de.pascalkuehnold.javareactmongodemoapp.service;

import de.pascalkuehnold.javareactmongodemoapp.entity.Movie;
import de.pascalkuehnold.javareactmongodemoapp.entity.Review;
import de.pascalkuehnold.javareactmongodemoapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private ReviewRepository reviewRepository;

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    public Review createReview(String reviewBody, String imdbId) {
        Review review = new Review(reviewBody, imdbId);

        reviewRepository.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }

}
