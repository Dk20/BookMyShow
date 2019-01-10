package org.BookMyShow.Repository;

import org.BookMyShow.Model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory,String> {
    Optional<Inventory> findBySeatIdAndDateTime(String seatId, String dateTime);
}
