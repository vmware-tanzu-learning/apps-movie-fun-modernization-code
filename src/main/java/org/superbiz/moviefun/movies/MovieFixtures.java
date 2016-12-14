package org.superbiz.moviefun.movies;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class MovieFixtures {

    public List<Movie> load() {
        return asList(
            new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005),
            new Movie("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004),
            new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003),
            new Movie("I-Spy", "Betty Thomas", "Adventure", 5, 2002),
            new Movie("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001),
            new Movie("Zoolander", "Ben Stiller", "Comedy", 6, 2001),
            new Movie("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000)
        );
    }
}
