package ru.job4j.jdbc;

public class City {

    private int id;
    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("City{id= %s, name= %s, population= %s}",
                id, name, population);
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setId(int anInt) {
    }

    /* геттеры и сеттеры */
}