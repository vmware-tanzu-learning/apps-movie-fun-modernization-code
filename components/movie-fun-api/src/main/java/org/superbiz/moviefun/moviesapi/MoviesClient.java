package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class MoviesClient {

    private String moviesUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<MovieInfo>> movieListType = new ParameterizedTypeReference<List<MovieInfo>>() {
    };

    public MoviesClient(String moviesUrl, RestOperations restOperations) {
        this.moviesUrl = moviesUrl;
        this.restOperations = restOperations;
    }

    public void addMovie(MovieInfo movie) {
        restOperations.postForEntity(moviesUrl, movie, MovieInfo.class);
    }

    public void deleteMovieId(Long movieId) {
        restOperations.delete(moviesUrl + "/" + movieId);
    }

    public int countAll() {
        return restOperations.getForObject(moviesUrl + "/count", Integer.class);
    }


    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesUrl + "/count")
            .queryParam("field", field)
            .queryParam("key", key);

        return restOperations.getForObject(builder.toUriString(), Integer.class);
    }


    public List<MovieInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesUrl)
            .queryParam("start", start)
            .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, movieListType).getBody();
    }

    public List<MovieInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesUrl)
            .queryParam("field", field)
            .queryParam("key", key)
            .queryParam("start", start)
            .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, movieListType).getBody();
    }

    public List<MovieInfo> getMovies() {
        return restOperations.exchange(moviesUrl, GET, null, movieListType).getBody();
    }
}
