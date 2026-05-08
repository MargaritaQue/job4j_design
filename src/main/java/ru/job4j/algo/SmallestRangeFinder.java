package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    /** Добавьте поля класса здесь, если это необходимо */

    public static int[] findSmallestRange(int[] nums, int k) {
        /** Добавьте реализацию метода здесь
         Метод должен принимать массив nums и целочисленное значение k,
         и возвращать массив из двух целых чисел, представляющих наименьший диапазон
         с k различными элементами в массиве nums
         Если такой диапазон найти невозможно, вернуть null
         **/
        return null; /** замените это на вашу реализацию */
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}