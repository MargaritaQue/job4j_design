package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        byte byteVar = 10;
        short shortVar = 200;
        int intVar = 3000;
        long longVar = 123456789L;
        float floatVar = 12.34F;
        double doubleVar = 56.78;
        char charVar = 'A';
        boolean boolVar = true;

        LOG.debug("byteVar : {}, shortVar : {}, intVar : {}, longVar : {}," +
                        "floatVar : {}, doubleVar : {}, charVar : {}, boolVar : {}",
                byteVar, shortVar, intVar, longVar, floatVar, doubleVar, charVar, boolVar
                );
    }
}