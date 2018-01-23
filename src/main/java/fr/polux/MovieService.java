package fr.polux;

import java.util.Iterator;
import java.util.List;

public class MovieService {

    public List<Movie> findByTitle(String searchString, List<Movie> movies) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie next = iterator.next();
            if (!next.getTitle().contains(searchString))
                iterator.remove();
        }
        return movies;
    }
}
