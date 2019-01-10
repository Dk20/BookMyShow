package org.BookMyShow.Service;

import org.BookMyShow.Model.Show;
import org.BookMyShow.Repository.ShowRepository;
import org.BookMyShow.thrift.gen.ShowThrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    private ShowRepository showRepository;
    @Autowired
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<ShowThrift> getAllShows(){
        List<Show> showFromDB = showRepository.findAll();
        List<ShowThrift>  showToEndpt = new ArrayList<ShowThrift>();
        //Converting to showThrift
        for (Show s:showFromDB) {
            showToEndpt.add(new ShowThrift(s.getId(),s.getMovieId(),s.getTheaterId(),s.getDateTime()));
        }
        return showToEndpt;
    }

    public List<ShowThrift> getShows(String tid,String dateTime){
        List<Show> showFromDB= showRepository.findByTheaterIdAndDateTime(tid,dateTime);
        List<ShowThrift>  showToEndpt = new ArrayList<ShowThrift>();
        //Converting to showThrift
        for (Show s:showFromDB) {
            showToEndpt.add(new ShowThrift(s.getId(),s.getMovieId(),s.getTheaterId(),s.getDateTime()));
        }
        return showToEndpt;
    }
}
