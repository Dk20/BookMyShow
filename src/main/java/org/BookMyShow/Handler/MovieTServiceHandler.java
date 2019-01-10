package org.BookMyShow.Handler;


import org.BookMyShow.Model.Movie;
import org.BookMyShow.Repository.MovieRepository;
import org.BookMyShow.thrift.gen.MovieThrift;
import org.BookMyShow.thrift.gen.MovieTService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieTServiceHandler implements MovieTService.Iface {

    private MovieRepository movieRepository;
    @Autowired
    public MovieTServiceHandler(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public boolean ping() throws TException {
        return true;
    }

    @Override
    public List<MovieThrift> getAllMovie() throws TException {
        List<Movie> moviesFromDB = movieRepository.findAll();
        List<MovieThrift> MovieToEndpt = new ArrayList<MovieThrift>();
        //Converting to movieThrift
        for (Movie m:moviesFromDB) {
            MovieToEndpt.add(new MovieThrift(m.getId(),m.getName(),m.getReleaseDate(),m.getRating()));
        }
        return MovieToEndpt;
    }
}

