package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().filter(line -> !line.isBlank() && !line.startsWith("#"))
                    .map(line -> line.split("=", 2))
                    .forEach(line -> {
                        if (line.length < 2 || line[0].isBlank() || line[1].isBlank()) {
                            throw new IllegalArgumentException("breaking the pattern");
                        }
                        values.put(line[0], line[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
        String c = "=";
        String[] s = c.split("=", 2);
        System.out.println(Arrays.toString(s));
        System.out.println(s.length);
        System.out.println(s[0]);
    }

}