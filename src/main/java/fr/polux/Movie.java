package fr.polux;

import java.util.Objects;

public class Movie {

    private String title;
    private int year;

    public Movie(String title, int year) {

        this.title = title;
        this.year = year;
    }

    public String getTitle() {

        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Movie setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Movie movie = (Movie) o;
        return year == movie.year && Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    @Override
    public String toString() {
        return "Movie{" + "title='" + title + '\'' + ", year=" + year + '}';
    }
}
