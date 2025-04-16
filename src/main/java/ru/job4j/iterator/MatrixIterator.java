package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
        row = 0;
        column = 0;
    }

    @Override
    public boolean hasNext() {
        if (data[row].length == column) {
            row += 1;
            column = 0;
        }
        if (data.length != row) {
            int x = data[row].length;
            while (x == 0) {
                row += 1;
                x = row == data.length ?  -1 : data[row].length;
            }
        }
        return (data.length != row);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}