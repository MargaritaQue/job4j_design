package ru.job4j.ood.lsp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ControlQualityTest {
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;
    private ControlQuality control;

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();

        control = new ControlQuality(Arrays.asList(warehouse, shop, trash));
    }

    @Test
    public void testDistributeFoodToWarehouse() {
        Food food = new Food("TestFood1", LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(90), 100, 0.1);

        control.control(food);

        assertTrue(warehouse.getFoods().contains(food), "Продукт должен попасть на склад");
        assertFalse(shop.getFoods().contains(food), "Продукт не должен попасть в магазин");
        assertFalse(trash.getFoods().contains(food), "Продукт не должен попасть в мусор");
    }

    @Test
    public void testDistributeFoodToShop() {
        Food food = new Food("TestFood2", LocalDate.now().minusDays(25),
                LocalDate.now().plusDays(75), 100, 0.1);

        control.control(food);

        assertFalse(warehouse.getFoods().contains(food), "Продукт не должен попасть на склад");
        assertTrue(shop.getFoods().contains(food), "Продукт должен попасть в магазин");
        assertFalse(trash.getFoods().contains(food), "Продукт не должен попасть в мусор");
    }

    @Test
    public void testDistributeFoodToTrash() {
        Food food = new Food("TestFood3", LocalDate.now().minusDays(80),
                LocalDate.now().minusDays(1), 100, 0.1);

        control.control(food);

        assertFalse(warehouse.getFoods().contains(food), "Продукт не должен попасть на склад");
        assertFalse(shop.getFoods().contains(food), "Продукт не должен попасть в магазин");
        assertTrue(trash.getFoods().contains(food), "Продукт должен попасть в мусор");
    }

    @Test
    public void testDiscountAppliedInShop() {
        Food food = new Food("TestFood4", LocalDate.now().minusDays(50),
                LocalDate.now().plusDays(10), 200, 0.2); // скидка 20%

        control.control(food);

        double expectedPrice = 200 * (1 - 0.2);
        assertEquals(expectedPrice, shop.getFoods().get(0).getPrice(), 0.001);
    }
}