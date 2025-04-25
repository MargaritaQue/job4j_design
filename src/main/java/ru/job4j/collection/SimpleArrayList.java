package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size > container.length - 1) {
            container = increase(container);
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T c = container[index];
        container[index] = newValue;
        return c;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T c = container[index];
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index -  1
        );
        size--;
        modCount++;
        return c;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        modCount++;
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    public T[] increase(T[] container) {
        T[] c = (T[]) new Object[container.length * 2 + 1];
        for (int i = 0; i < container.length; i++) {
            c[i] = container[i];
        }
        return c;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int c = modCount;
            int point = 0;
            @Override
            public boolean hasNext() {
                if (c != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < container.length && point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}