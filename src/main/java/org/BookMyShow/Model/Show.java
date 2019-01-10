package org.BookMyShow.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
// TODO : Convertors
@Document(collection = "Show")
@TypeAlias("Show")
public class Show {
    @Id
    private String id;
    private String movieId;
    private String theaterId;
    private String dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Show(String movieId, String theaterId, String dateTime) {
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.dateTime = dateTime;
    }
}
