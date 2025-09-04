package ru.job4j.ood.lsp.parking;

public abstract class Car {
    protected final int size;
    protected final String number;

    public Car(int size, String number) {
        if (!valid(size)) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }

    abstract boolean valid(int size);
}