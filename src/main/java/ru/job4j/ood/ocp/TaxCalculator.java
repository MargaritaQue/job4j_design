package ru.job4j.ood.ocp;

public class TaxCalculator {

    public double calculateTax(String region, double income) {
        if (region.equals("RegionA")) {
            return income * 0.1;
        } else if (region.equals("RegionB")) {
            return income * 0.2;
        }
        return 0;
    }
}
