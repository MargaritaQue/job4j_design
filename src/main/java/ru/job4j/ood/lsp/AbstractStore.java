package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    List<Food> foods = new ArrayList<>();

    public static double productExpirationDate(Food food) {
        LocalDate expiryDate = food.getExpiryDate();
        LocalDate createDate = food.getCreateDate();
        long shelfLifeInDays = ChronoUnit.DAYS.between(createDate, expiryDate);
        long daysHavePassed = ChronoUnit.DAYS.between(createDate, LocalDate.now());
        return 100d * daysHavePassed / shelfLifeInDays;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }
}
