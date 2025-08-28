package ru.job4j.ood.lsp;

public class Trash extends AbstractStore {

    public boolean accept(Food food) {
        return productExpirationDate(food) > 99;
    }
}
