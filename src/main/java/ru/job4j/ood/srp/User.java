package ru.job4j.ood.srp;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void printUser() {
        System.out.println("User: " + name);
    }
}