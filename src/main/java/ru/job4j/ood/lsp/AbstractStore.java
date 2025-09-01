package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> foods = new ArrayList<>();
    protected static final int CONSTANT_25 = 25;
    protected static final int CONSTANT_75 = 75;
    protected static final int CONSTANT_100 = 100;

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }
}
