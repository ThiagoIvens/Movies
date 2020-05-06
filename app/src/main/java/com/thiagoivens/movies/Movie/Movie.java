package com.thiagoivens.movies.Movie;

import com.thiagoivens.movies.Actor.Actor;
import com.thiagoivens.movies.Director.Director;

public class Movie {
    private String Title;
    private String Genero;
    private int Ano;
    private Actor actor;
    private Director director;
    private int img;

    public Movie() {
    }

    public Movie(String title, String genero, int ano, Actor actor, Director director, int img) {
        Title = title;
        Genero = genero;
        Ano = ano;
        this.actor = actor;
        this.director = director;
        this.img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        Ano = ano;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
