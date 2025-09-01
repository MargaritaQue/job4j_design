package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Expiration {

    public static double productExpirationDate(Food food) {
        LocalDate expiryDate = food.getExpiryDate();
        LocalDate createDate = food.getCreateDate();
        long shelfLifeInDays = ChronoUnit.DAYS.between(createDate, expiryDate);
        long daysHavePassed = ChronoUnit.DAYS.between(createDate, LocalDate.now());
        return 100d * daysHavePassed / shelfLifeInDays;
    }

}
