package org.BookMyShow.Repository;

import org.BookMyShow.Model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends MongoRepository<Show,String> {
    List<Show> findByTheaterIdAndDateTime(String theaterId, String dateTime);
}
