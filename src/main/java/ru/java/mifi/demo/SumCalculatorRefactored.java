package ru.java.mifi.demo;

public class SumCalculatorRefactored {

    /**
     * Метод суммирует любое количество целочисленных значений.
     *
     * @param numbers массив любых целочисленных значений
     * @return сумма всех переданных чисел
     */
    public static long sum(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Переданы нулевые аргументы");
        }

        long total = 0L;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}