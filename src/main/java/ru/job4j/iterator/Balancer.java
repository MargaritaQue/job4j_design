package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        Iterator<ArrayList<Integer>> iterator = nodes.iterator();
        while (source.hasNext()) {
            if (iterator.hasNext()) {
                iterator.next().add(source.next());
            } else {
                iterator = nodes.iterator();
            }
        }
    }
}