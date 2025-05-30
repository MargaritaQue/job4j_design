package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    private Iterator<T> cursor;

    public CyclicIterator(List<T> data) {
        this.data = data;
        cursor = data.iterator();
    }

    @Override
    public boolean hasNext() {
        if (!cursor.hasNext()) {
            cursor = data.iterator();
        }
        return !data.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }
}