package ru.job4j.ood.isp;

public interface Printer {
    void print(Document doc);

    void scan(Document doc);

    void fax(Document doc);
}
