package de.pascalkuehnold.javareactmongodemoapp.repository;

import de.pascalkuehnold.javareactmongodemoapp.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
