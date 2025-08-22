package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class GeneratorTest {

    private final Generator generator = new SimpleGenerator();

    @Test
    public void whenTheReplacementIsIone() {
        String template = "I am ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");

        String res = generator.produce(template, map);
        assertEquals("I am a Petr Arsentev, Who are you? ", res);
    }

    @Test
    public void whenThereAreFewerKeys() {
        String template = "I am ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");

        String res = generator.produce(template, map);
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, map));
    }

    @Test
    public void whenThereAreMoreKeys() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("age", "12");

        String res = generator.produce(template, map);
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, map));
    }

    @Test
    public void whenThereIsTheSameKey() {
        String template = "I am ${name}, Who are ${subject}? I am also ${name}";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ayanami Rei");
        map.put("subject", "you");

        String res = generator.produce(template, map);
        assertEquals("I am Ayanami Rei, Who are you? I am also Ayanami Rei", res);
    }
}