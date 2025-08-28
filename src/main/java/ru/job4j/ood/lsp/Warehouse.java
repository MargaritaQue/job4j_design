package ru.job4j.ood.lsp;

public class Warehouse extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        return productExpirationDate(food) <= 24;
    }
}
