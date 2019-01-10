package org.BookMyShow;

import org.BookMyShow.Model.Movie;
import org.BookMyShow.Model.User;
import org.BookMyShow.Repository.MovieRepository;
import org.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@ConditionalOnProperty("org.BookMyShow.DBseeder.enabled")
@Component
public class DBseeder implements CommandLineRunner {


    private MovieRepository movieRepository;
    private UserRepository userRepository;
    @Autowired
    public DBseeder(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Movie m1 = new Movie(
                "Grinch",
                "12-1-19",
                5
         );
        Movie m2 = new Movie(
                "Aqaman",
                "13-1-19",
                4
        );
        movieRepository.deleteAll();
        List<Movie> moviesList = Arrays.asList(m1,m2);
        this.movieRepository.saveAll(moviesList);

        User u1 = new User("DK","Admin1");
        User u2 = new User("AJ","Admin2");
        userRepository.deleteAll();
        List<User> usersList = Arrays.asList(u1,u2);
        userRepository.saveAll(usersList);

    }
}
