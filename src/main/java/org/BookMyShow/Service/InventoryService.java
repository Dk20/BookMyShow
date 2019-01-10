package org.BookMyShow.Service;

import org.BookMyShow.Model.Inventory;
import org.BookMyShow.Model.Seat;
import org.BookMyShow.Repository.InventoryRepository;
import org.BookMyShow.Repository.SeatRepository;
import org.BookMyShow.thrift.gen.InventoryThrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private SeatRepository seatRepository;
    private InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService(SeatRepository seatRepository, InventoryRepository inventoryRepository) {
        this.seatRepository = seatRepository;
        this.inventoryRepository = inventoryRepository;
    }




    public List<InventoryThrift> getSeats(String tid,String date){
        //System.out.println(tid+" "+date);

        List<Seat> seats = seatRepository.findCustomByTheaterId(tid);
        //System.out.println(seats);
        List<Inventory> inventoryList = new ArrayList<Inventory>();
        Optional<Inventory> inventory;

        for (Seat s: seats) {
            //System.out.println(s.getId()+" "+date);
            inventory = inventoryRepository.findBySeatIdAndDateTime(s.getId(),date);
            //System.out.println(inventory.isPresent());
            if(inventory.isPresent())
                inventoryList.add(inventory.get());
        }

        System.out.println(inventoryList);

        List<InventoryThrift> inventoryThriftList = new ArrayList<InventoryThrift>();
        for (Inventory i: inventoryList) {

            inventoryThriftList.add(new InventoryThrift(i.getSeatId(),i.getDateTime(),i.getStatusBool()));
        }
        return inventoryThriftList;
    }

    public List<InventoryThrift> bookSeats(List<String> seatIds,String date){

        Optional<Inventory> tempInv;
        List<InventoryThrift>  OutList = new ArrayList<InventoryThrift>();
        for (String id: seatIds) {

            tempInv = inventoryRepository.findBySeatIdAndDateTime(id,date);
            if(!tempInv.isPresent()) continue;

            if(!tempInv.get().getStatusBool()) continue;
            else tempInv.get().setStatus("Booked");

            inventoryRepository.save(tempInv.get());
            OutList.add(tempInv.get().converterToThrift());
        }
        return OutList;
    }
}
