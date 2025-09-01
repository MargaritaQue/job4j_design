package ru.job4j.ood.lsp;

public class Shop extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        if (Expiration.productExpirationDate(food) >= CONSTANT_25 && Expiration.productExpirationDate(food) <= CONSTANT_75) {
            return true;
        } else if (Expiration.productExpirationDate(food) > CONSTANT_75 && Expiration.productExpirationDate(food) < CONSTANT_100) {
            food.setPrice(food.getPrice() * (1.0 - food.getDiscount()));
            return true;
        }
        return false;
    }
}
