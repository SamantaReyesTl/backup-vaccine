package com.example;

public class Productos{
    String name;
    String caducidad;

    public Productos(String name, String caducidad) {
        this.name = name;
        this.caducidad = caducidad;
    }

    public String getName() {
        return name;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
}
