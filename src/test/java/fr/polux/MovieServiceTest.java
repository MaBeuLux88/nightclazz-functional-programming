package fr.polux;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceTest {

    private final MovieService movieService = new MovieService();

    @Test
    public void shouldReturnEmptyWhenNoneFound() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Matrix", 1999));
        movies.add(new Movie("A beautiful mind", 2001));
        movies.add(new Movie("Intouchable", 2011));
        movies.add(new Movie("Forest Gump", 1994));
        List<Movie> moviesFound = movieService.findByTitle.apply("Interstellar").apply(movies);
        assertThat(moviesFound).isEmpty();
    }

    @Test
    public void shouldReturnMatchingMovieWhenFound() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Matrix", 1999));
        movies.add(new Movie("A beautiful mind", 2001));
        movies.add(new Movie("Intouchable", 2011));
        movies.add(new Movie("Forest Gump", 1994));
        List<Movie> moviesFound = movieService.findByTitle.apply("The Matrix").apply(movies);
        assertThat(moviesFound).containsExactly(new Movie("The Matrix", 1999));
    }

    @Test
    public void shouldReturnAllMatchingMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Matrix", 1999));
        movies.add(new Movie("A beautiful mind", 2001));
        movies.add(new Movie("Intouchable", 2011));
        movies.add(new Movie("Forest Gump", 1994));
        List<Movie> moviesFound = movieService.findByTitle.apply("o").apply(movies);
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie("Intouchable", 2011));
        expectedMovies.add(new Movie("Forest Gump", 1994));
        assertThat(moviesFound).containsAll(expectedMovies);
    }

}
