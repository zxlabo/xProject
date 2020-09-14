package com.example.myapplication;

public class arraybean {

    public arraybean(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "arraybean{" +
                "name='" + name + '\'' +
                '}';
    }
}
