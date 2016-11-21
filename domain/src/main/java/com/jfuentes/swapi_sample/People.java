package com.jfuentes.swapi_sample;

import java.util.List;

public class People {

    private String name;
    private String height;
    private String gender;
    private List<String> filmsUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getFilmsUrl() {
        return filmsUrl;
    }

    public void setFilmsUrl(List<String> filmsUrl) {
        this.filmsUrl = filmsUrl;
    }
}
