package com.example.project;

public class Planet {

    private String name;
    private int size;
    private String location;
    private String category;


    public Planet(String name, int size, String location, String category) {
        this.name = name;
        this.size = size;
        this.location = location;
        this.category = category;
    }

    public String getName() {

        return name;
    }

    public int getSize() { // Getter returns int

        return size;
    }

    public String getLocation() {

        return location;
    }

    public String getCategory() {

        return category;
    }

    @Override
    public String toString(){
        return name + size + location + category;
    }
}