package org.BookMyShow.Handler;

import org.BookMyShow.Service.ShowService;
import org.BookMyShow.thrift.gen.ShowTService;
import org.BookMyShow.thrift.gen.ShowThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTServiceHandler implements ShowTService.Iface {
    private ShowService showService;
    @Autowired
    public ShowTServiceHandler(ShowService showService) {
        this.showService = showService;
    }

    @Override
    public boolean ping() throws TException {
        return true;
    }

    @Override
    public List<ShowThrift> getAllShow() throws TException {
        return showService.getAllShows();
    }

    @Override
    public List<ShowThrift> getShows(String theaterId, String dateTime) throws TException {
        return showService.getShows(theaterId,dateTime);
    }

}
