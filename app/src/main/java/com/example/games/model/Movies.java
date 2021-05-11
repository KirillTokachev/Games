package com.example.games.model;

public class Movies {
    private String title;
    private String posterUrl;
    private String released;

    public Movies() {
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }


    public String getReleased() {
        return released;
    }

    public void setTitle(String gameName) {
        this.title = gameName;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }


    public void setReleased(String released) {
        this.released = released;
    }

}
