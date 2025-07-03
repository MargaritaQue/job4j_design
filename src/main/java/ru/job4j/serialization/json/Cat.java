package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        final Cat cat = new Cat(false, 1, "Tolya",
                new String[] {"Vaccinated", "Sterilized"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(cat));

        final String catJson =
                "{"
                        + "\"sex\":true,"
                        + "\"age\":2,"
                        + "\"name\":Musya,"
                        + "\"statuses\":"
                        + "[\"Vaccinated\",\"Sterilized\"]"
                        + "}";

        final Cat catMod = gson.fromJson(catJson, Cat.class);
        System.out.println(catMod);
    }
}
