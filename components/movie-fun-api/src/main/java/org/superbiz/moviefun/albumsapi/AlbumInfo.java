package org.superbiz.moviefun.albumsapi;

public class AlbumInfo {

    private Long id;
    private String artist;
    private String title;
    private int year;
    private int rating;

    public AlbumInfo() {
    }

    public AlbumInfo(Long id, String artist, String title, int year, int rating) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumInfo albumInfo = (AlbumInfo) o;

        if (year != albumInfo.year) return false;
        if (rating != albumInfo.rating) return false;
        if (id != null ? !id.equals(albumInfo.id) : albumInfo.id != null) return false;
        if (artist != null ? !artist.equals(albumInfo.artist) : albumInfo.artist != null) return false;
        return title != null ? title.equals(albumInfo.title) : albumInfo.title == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "AlbumInfo{" +
            "id=" + id +
            ", artist='" + artist + '\'' +
            ", title='" + title + '\'' +
            ", year=" + year +
            ", rating=" + rating +
            '}';
    }
}
