package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<T>();
    private final SimpleStack<T> output = new SimpleStack<T>();
    private int size;

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int s = size;
        while (size != 1) {
            output.push(input.pop());
            size--;
        }
        T x = input.pop();
        while (s != size) {
            input.push(output.pop());
            size++;
        }
        size--;
        return x;
    }

    public void push(T value) {
        input.push(value);
        size++;
    }
}