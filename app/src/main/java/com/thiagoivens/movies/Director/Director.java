package com.thiagoivens.movies.Director;

import androidx.annotation.NonNull;

import com.thiagoivens.movies.Actor.Actor;

public class Director {

    private String nome;
    private int idade;
    private int img;

    public Director() {
    }

    public Director(String nome, int idade, int img) {
        this.nome = nome;
        this.idade = idade;
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

}
