package org.BookMyShow.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
// TODO : Convertors
@Document(collection = "Movie")
@TypeAlias("Movie")
public class Movie {
    @Id
    private String id;
    private String name;
    private String releaseDate;
    private int rating;

    public Movie(String name, String releaseDate, int rating) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRating() {
        return rating;
    }
}
