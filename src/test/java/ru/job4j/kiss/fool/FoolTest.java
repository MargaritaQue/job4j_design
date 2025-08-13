package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {
    @Test
    public void testGetExpectedAnswer() {
        assertEquals("1", Fool.getExpectedAnswer(1));
        assertEquals("2", Fool.getExpectedAnswer(2));
        assertEquals("Fizz", Fool.getExpectedAnswer(3));
        assertEquals("4", Fool.getExpectedAnswer(4));
        assertEquals("Buzz", Fool.getExpectedAnswer(5));
        assertEquals("Fizz", Fool.getExpectedAnswer(6));
        assertEquals("7", Fool.getExpectedAnswer(7));
        assertEquals("8", Fool.getExpectedAnswer(8));
        assertEquals("Fizz", Fool.getExpectedAnswer(9));
        assertEquals("Buzz", Fool.getExpectedAnswer(10));
        assertEquals("11", Fool.getExpectedAnswer(11));
        assertEquals("Fizz", Fool.getExpectedAnswer(12));
        assertEquals("13", Fool.getExpectedAnswer(13));
        assertEquals("14", Fool.getExpectedAnswer(14));
        assertEquals("FizzBuzz", Fool.getExpectedAnswer(15));
    }

    @Test
    public void testGetExpectedAnswerForMultipleOfThreeAndFive() {
        assertEquals("FizzBuzz", Fool.getExpectedAnswer(30));
        assertEquals("FizzBuzz", Fool.getExpectedAnswer(60));
    }

    @Test
    public void testGetExpectedAnswerForOnlyThree() {
        assertEquals("Fizz", Fool.getExpectedAnswer(9));
        assertEquals("Fizz", Fool.getExpectedAnswer(12));
    }

    @Test
    public void testGetExpectedAnswerForOnlyFive() {
        assertEquals("Buzz", Fool.getExpectedAnswer(10));
        assertEquals("Buzz", Fool.getExpectedAnswer(20));
    }
}