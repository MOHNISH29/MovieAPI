package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Movies")
public class Movie {

    @Id
private ObjectId id;
private String imdbId;
private String title;
private String releaseDate;
private String trailerLink;
private String poster;
private List<String> genres;
private List<String> backdrops;
private List<Review> reviewIds;
}
