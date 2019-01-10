package org.BookMyShow.Model;

import org.BookMyShow.thrift.gen.InventoryThrift;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@CompoundIndex(name = "seatId_1_dateTime_1",def = "{'seatId':1,'dateTime':1}")
@Document(collection = "Inventory")
@TypeAlias("Inventory")
public class Inventory {
    @Id
    private String id;
    private String seatId;
    private String dateTime;
    private String status;
    @Version
    private Long version;

    public Inventory(String seatId, String dateTime, String status) {
        this.seatId = seatId;
        this.dateTime = dateTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getStatusBool(){
        return this.getStatus().equals("Available");
    }

    public InventoryThrift converterToThrift(){
        return new InventoryThrift(this.getSeatId(),this.getDateTime(),getStatusBool());
    }
}
