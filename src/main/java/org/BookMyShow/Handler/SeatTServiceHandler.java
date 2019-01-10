package org.BookMyShow.Handler;

import org.BookMyShow.Service.InventoryService;
import org.BookMyShow.thrift.gen.InventoryThrift;
import org.BookMyShow.thrift.gen.SeatTService;
import org.BookMyShow.thrift.gen.ShowThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatTServiceHandler implements SeatTService.Iface {
    private InventoryService inventoryService;
    @Autowired
    public SeatTServiceHandler(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public List<InventoryThrift> getSeats(ShowThrift show) throws TException {
        //System.out.println("Hit!");
        return inventoryService.getSeats(show.getTheaterId(),show.getDateTime());
    }

    @Override
    public List<InventoryThrift> bookSeats(List<String> seatIds, String dateTime) throws TException {
        return inventoryService.bookSeats(seatIds,dateTime);
    }
}
