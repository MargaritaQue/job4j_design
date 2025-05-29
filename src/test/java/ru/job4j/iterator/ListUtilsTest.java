package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterLast() {
        ListUtils.addAfter(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 3, 2);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 2, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.addAfter(input, 1, 2);
        Predicate<Integer> f = n -> n % 3 == 0;
        ListUtils.removeIf(input, f);
        assertThat(input).hasSize(2).containsSequence(1, 2);
    }

    @Test
    void whenNotRemoveIf() {
        Predicate<Integer> f = n -> n % 2 == 0;
        ListUtils.removeIf(input, f);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.addBefore(input, 1, 2);
        Predicate<Integer> f = n -> n % 3 == 0;
        ListUtils.replaceIf(input, f, 5);
        assertThat(input).hasSize(3).containsSequence(1, 2, 5);
    }

    @Test
    void whenNotReplaceIf() {
        Predicate<Integer> f = n -> n % 2 == 0;
        ListUtils.replaceIf(input, f, 5);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(1).containsSequence(3);
    }

    @Test
    void whenNotRemoveAll() {
        List<Integer> elements = new ArrayList<>(Arrays.asList(4, 5));
        ListUtils.removeAll(input, elements);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }
}