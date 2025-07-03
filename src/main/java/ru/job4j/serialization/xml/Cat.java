package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Cat {
    private final boolean sex;
    private final int age;
    private final String name;
    private final String[] statuses;

    public Cat(boolean sex, int age, String name, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", name=" + name
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {
        final ru.job4j.serialization.json.Cat cat = new ru.job4j.serialization.json.Cat(false, 1, "Tolya",
                new String[] {"Vaccinated", "Sterilized"});
    }
}
