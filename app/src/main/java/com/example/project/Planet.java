package com.example.project;

public class Planet {

    private String name;
    private int size;


    public Planet(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() { // Getter returns int
        return size;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Size: " + size;

    }
}