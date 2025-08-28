package ru.job4j.ood.lsp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StoreTest {
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
    }

    @Test
    public void testAddAndGetFoodsWarehouse() {
        Food food = new Food("Milk", LocalDate.now().minusDays(1), LocalDate.now().plusDays(10), 100, 0.1);
        warehouse.add(food);
        assertTrue(warehouse.getFoods().contains(food));
    }

    @Test
    public void testAddAndGetFoodsShop() {
        Food food = new Food("Bread", LocalDate.now().minusDays(5), LocalDate.now().plusDays(20), 50, 0.2);
        shop.add(food);
        assertTrue(shop.getFoods().contains(food));
    }

    @Test
    public void testTrashAccept() {
        Food expiredFood = new Food(
                "Old Meat",
                LocalDate.now().minusDays(210),
                LocalDate.now().minusDays(200),
                100.0,
                0.0
        );

        assertTrue(trash.accept(expiredFood));

        Food freshFood = new Food(
                "Fresh Fruit",
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(50),
                50.0,
                0.2
        );

        assertFalse(trash.accept(freshFood));
    }
}