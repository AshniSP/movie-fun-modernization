package org.superbiz.moviefun.albumsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.moviesapi.MovieInfo;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String albumsUrl;
    private RestOperations restOperations;



    public AlbumsClient(String moviesUrl, RestOperations restOperations){

        this.albumsUrl=albumsUrl;
        this.restOperations=restOperations;
    }


    public void addAlbum(AlbumInfo albumInfo) {
        restOperations.postForEntity(albumsUrl,albumInfo,MovieInfo.class);
    }

/*
     public void deleteMovie(Long movieId) {
        restOperations.delete(albumsUrl+"/",movieId);
    }

    public int countAll(){
        return restOperations.getForObject(albumsUrl+"/count",Integer.class);

    }

    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key);

        return restOperations.getForObject(builder.toUriString(), Integer.class);
    }*/


    public AlbumInfo find(long id) {
        return restOperations.getForEntity(albumsUrl + "/" + id, AlbumInfo.class).getBody();
    }
/*    public List<MovieInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, movieListType).getBody();
    }

    public List<MovieInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, movieListType).getBody();
    }*/

    public List<MovieInfo> getAlbums() {
        ParameterizedTypeReference<List<MovieInfo>> albumListType = new ParameterizedTypeReference<List<MovieInfo>>() {
        };
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }
}
