package ru.job4j.ood.isp;

public class OldPrinter implements Printer {
    @Override
    public void print(Document doc) {
        System.out.println("Printing document");
    }

    @Override
    public void scan(Document doc) {
        throw new UnsupportedOperationException("OldPrinter cannot scan");
    }

    @Override
    public void fax(Document doc) {
        throw new UnsupportedOperationException("OldPrinter cannot fax");
    }
}
