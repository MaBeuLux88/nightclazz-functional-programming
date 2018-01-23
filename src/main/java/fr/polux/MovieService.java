package fr.polux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MovieService {

    public List<Movie> findByTitle(String searchString, List<Movie> movies) {
        ArrayList<Movie> moviesFound = new ArrayList<>();
        BiFunction<String, Movie, Boolean> searchMethod = this::matches;

        Consumer<Movie> add = movie -> moviesFound.add(movie);

        for (Movie movie : movies) {
            addIf(searchMethod, searchString, movie, add);
        }
        return moviesFound;
    }

    private void addIf(BiFunction<String, Movie, Boolean> searchMethod, String searchString, Movie movie,
                       Consumer<Movie> add) {
        if (searchMethod.apply(searchString, movie))
            add.accept(movie);
    }

    private boolean matches(String searchString, Movie movie) {
        return containsSearchString(searchString, movie.getTitle());
    }

    private boolean containsSearchString(String searchString, String movie) {
        return movie.contains(searchString);
    }
}
