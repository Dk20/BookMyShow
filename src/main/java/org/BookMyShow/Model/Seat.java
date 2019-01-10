package org.BookMyShow.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// TODO : Convertors
@Document(collection = "Seat")
public class Seat {
    @Id
    private String id;
    private String theaterId;
    private String name;

    public Seat(String theaterId, String name) {
        this.theaterId = theaterId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
