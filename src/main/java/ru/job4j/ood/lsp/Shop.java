package ru.job4j.ood.lsp;

public class Shop extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        if (productExpirationDate(food) >= 25 && productExpirationDate(food) <= 75) {
            return true;
        } else if (productExpirationDate(food) >= 76 && productExpirationDate(food) <= 99) {
            food.setPrice(food.getPrice() * (1.0 - food.getDiscount()));
            return true;
        }
        return false;
    }
}
