package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody Map<String,String> payload)
    {
        Review rv = reviewService.createReview(payload.get("reviewBody") , payload.get("ImdbId"));
        return new ResponseEntity<Review>(rv , HttpStatus.CREATED);
    }
}
