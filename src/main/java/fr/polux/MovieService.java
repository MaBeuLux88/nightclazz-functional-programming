package fr.polux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MovieService {

    private Function<String, Function<String, Boolean>> containsSearchString = searchString -> movie -> movie.contains(
            searchString);

    private Function<String, Function<Movie, Boolean>> matches = searchString -> movie -> containsSearchString.apply(
            searchString).apply(movie.getTitle());

    public Function<String, Function<List<Movie>, List<Movie>>> findByTitle = searchString -> movies -> {
        List<Movie> moviesFound = new ArrayList<>();

        Function<String, Function<Movie, Boolean>> searchMethod = matches;

        Function<Movie, Function<List<Movie>, List<Movie>>> add = m -> list -> {
            List<Movie> result = new ArrayList<>(list);
            result.add(m);
            return result;
        };

        for (Movie movie : movies) {
            moviesFound = addIf(searchMethod, searchString, movie, add).apply(moviesFound);
        }
        return moviesFound;
    };

    private Function<List<Movie>, List<Movie>> addIf(Function<String, Function<Movie, Boolean>> searchMethod,
                                                     String searchString, Movie movie,
                                                     Function<Movie, Function<List<Movie>, List<Movie>>> add) {
        if (searchMethod.apply(searchString).apply(movie))
            return add.apply(movie);
        return l -> l;

    }

}
