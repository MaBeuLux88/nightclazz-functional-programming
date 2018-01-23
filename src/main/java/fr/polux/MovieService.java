package fr.polux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MovieService {

    public List<Movie> findByTitle(String searchString, List<Movie> movies) {
        ArrayList<Movie> moviesFound = new ArrayList<>();
        BiFunction<String, Movie, Boolean> searchMethod = this::matches;

        Consumer<Movie> add = moviesFound::add;

        for (Movie movie : movies)
            addIf(searchMethod, searchString, movie, add).accept(movie);
        return moviesFound;
    }

    private Consumer<Movie> addIf(BiFunction<String, Movie, Boolean> searchMethod, String searchString, Movie movie,
                                  Consumer<Movie> add) {
        if (searchMethod.apply(searchString, movie))
            return add;
        return m -> {};

    }

    private boolean matches(String searchString, Movie movie) {
        return containsSearchString(searchString, movie.getTitle());
    }

    private boolean containsSearchString(String searchString, String movie) {
        return movie.contains(searchString);
    }
}
