package org.BookMyShow.Repository;

import org.BookMyShow.Model.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends MongoRepository<Seat,String> {
    @Query(value = "{theaterId : ?0}",fields = "{}")
    List<Seat> findCustomByTheaterId(String theaterId);
}
