package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody , String imdbId)
    {

        Review rev = reviewRepo.insert(new Review(reviewBody));

        //this template gives us a method to update already existing
        //database on the basis of certain conditions
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(rev)).first();

        return rev;

    }
}
