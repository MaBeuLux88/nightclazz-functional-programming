package fr.polux;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public List<Movie> findByTitle(String searchString, List<Movie> movies) {
        ArrayList<Movie> moviesFound = new ArrayList<>();
        for (Movie movie : movies) {
            addIfMatches(searchString, moviesFound, movie);
        }
        return moviesFound;
    }

    private void addIfMatches(String searchString, ArrayList<Movie> moviesFound, Movie movie) {
        if (matches(searchString, movie))
            moviesFound.add(movie);
    }

    private boolean matches(String searchString, Movie movie) {
        return containsSearchString(searchString, movie.getTitle());
    }

    private boolean containsSearchString(String searchString, String movie) {
        return movie.contains(searchString);
    }
}
