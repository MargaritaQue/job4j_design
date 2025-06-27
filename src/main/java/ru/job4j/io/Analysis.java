package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader input = new BufferedReader(new FileReader(source));
            PrintWriter output = new PrintWriter(new FileOutputStream(target))) {
                boolean work = false;
                String[] pair;
                while (input.ready()) {
                    pair = input.readLine().split("\\s");
                    if (!work) {
                        if ("400".equals(pair[0]) || "500".equals(pair[0])) {
                            output.print(pair[1] + ";");
                            work = true;
                        }
                    } else {
                        if ("200".equals(pair[0]) || "300".equals(pair[0])) {
                            output.println(pair[1]);
                            work = false;
                        }
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}