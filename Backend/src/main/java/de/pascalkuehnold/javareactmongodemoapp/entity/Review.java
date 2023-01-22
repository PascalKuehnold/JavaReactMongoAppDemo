package de.pascalkuehnold.javareactmongodemoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {

    @Id
    private ObjectId reviewId;

    private String body;

    private String imdbId;

    public Review(String body, String imdbId) {
        this.body = body;
        this.imdbId = imdbId;
    }
}
