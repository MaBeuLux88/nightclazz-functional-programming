package fr.polux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MovieService {

    public List<Movie> findByTitle(String searchString, List<Movie> movies) {
        ArrayList<Movie> moviesFound = new ArrayList<>();

        BiFunction<String, Movie, Boolean> searchMethod = this::matches;

        for (Movie movie : movies) {
            addIfMatches(searchMethod, searchString, moviesFound, movie);
        }
        return moviesFound;
    }

    private void addIfMatches(BiFunction<String, Movie, Boolean> searchMethod, String searchString,
                              ArrayList<Movie> moviesFound, Movie movie) {
        if (searchMethod.apply(searchString, movie))
            moviesFound.add(movie);
    }

    private boolean matches(String searchString, Movie movie) {
        return containsSearchString(searchString, movie.getTitle());
    }

    private boolean containsSearchString(String searchString, String movie) {
        return movie.contains(searchString);
    }
}
