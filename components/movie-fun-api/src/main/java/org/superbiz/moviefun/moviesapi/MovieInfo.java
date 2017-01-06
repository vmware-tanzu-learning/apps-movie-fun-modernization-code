package org.superbiz.moviefun.moviesapi;

public class MovieInfo {
    private Long id;
    private String title;
    private String director;
    private String genre;
    private int rating;
    private int year;

    public MovieInfo() {
    }

    public MovieInfo(Long id, String title, String director, String genre, int rating, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieInfo movieInfo = (MovieInfo) o;

        if (id != movieInfo.id) return false;
        if (year != movieInfo.year) return false;
        if (rating != movieInfo.rating) return false;
        if (director != null ? !director.equals(movieInfo.director) : movieInfo.director != null) return false;
        if (title != null ? !title.equals(movieInfo.title) : movieInfo.title != null) return false;
        return genre != null ? genre.equals(movieInfo.genre) : movieInfo.genre == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
            "id=" + id +
            ", director='" + director + '\'' +
            ", title='" + title + '\'' +
            ", year=" + year +
            ", genre='" + genre + '\'' +
            ", rating=" + rating +
            '}';
    }
}
