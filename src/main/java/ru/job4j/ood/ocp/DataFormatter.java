package ru.job4j.ood.ocp;

public class DataFormatter {
    public String format(String formatType, Object data) {
        if (formatType.equals("JSON")) {
            return "формат JSON";
        } else if (formatType.equals("XML")) {
            return "формат XML";
        }
        return "";
    }
}
