package ru.job4j.ood.lsp;

public class Warehouse extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        return Expiration.productExpirationDate(food) < CONSTANT_25;
    }
}
