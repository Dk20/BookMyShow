package org.BookMyShow.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
// TODO : Convertors
@Document
@TypeAlias("Theater")
public class Theater {
    @Id
    private String id;
    private String name;
    private String city;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Theater(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
