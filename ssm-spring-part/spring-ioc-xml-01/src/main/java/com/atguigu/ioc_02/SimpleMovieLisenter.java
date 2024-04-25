package com.atguigu.ioc_02;

public class SimpleMovieLisenter {
    private MovieFinder movieFinder;

    private String movieName;

    public void setSovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
