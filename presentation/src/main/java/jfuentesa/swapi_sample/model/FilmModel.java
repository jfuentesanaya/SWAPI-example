package jfuentesa.swapi_sample.model;

/**
 * Created by jfuentesa on 21/11/2016.
 */

public class FilmModel {

    private String title;
    private int episodeId;
    private String director;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
