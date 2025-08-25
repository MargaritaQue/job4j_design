package ru.job4j.ood.ocp;

public class ShippingCostCalculator {
    public double calculateCost(String method) {
        if (method.equals("Courier")) {
            return 10.0;
        } else if (method.equals("Pickup")) {
            return 0.0;
        }
        return 0.0;
    }
}