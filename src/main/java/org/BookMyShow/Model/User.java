package org.BookMyShow.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
// TODO : Convertors
@Document("User")
@TypeAlias("User")
public class User {
     @Id
     private String id;
     private String uname;
     private String upass;

    public void setId(String id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public String getUpass() {
        return upass;
    }

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }
}
