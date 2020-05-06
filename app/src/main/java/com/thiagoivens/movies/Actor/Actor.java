package com.thiagoivens.movies.Actor;

import androidx.annotation.NonNull;

public class Actor {
    private String nome;
    private int idade;
    private int img;

    public Actor() {
    }

    public Actor(String nome, int idade, int img) {
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
