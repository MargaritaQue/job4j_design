package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five")
                .doesNotContain("un", "deux", "trois")
                .startsWith("first", "second");
        assertThat(list).isNotNull()
                .anyMatch(e -> e.equals("first"))
                .noneMatch(e -> e.length() < 3);
        assertThat(list).first().isEqualTo("first");
        assertThat(list).element(0).isNotNull()
                .isEqualTo("first");
        assertThat(list).last().isNotNull()
                .isEqualTo("five");
        assertThat(list).filteredOn(e -> e.length() > 1).first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "first", "second", "three", "four", "five");
        assertThat(set).isNotNull()
                .anyMatch(e -> e.equals("first"))
                .noneMatch(e -> e.length() < 3);
        assertThat(set).hasSize(5)
                .contains("second")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("un", "deux", "trois");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second")
                .containsValues(0, 1)
                .doesNotContainKey("un")
                .doesNotContainValue(5)
                .containsEntry("first", 0);
    }

}