package ru.java.mifi.demo;

public class Calculator {

    public static int add(int i, int j) {
        return i + j;
    }

    public static int subtract(int i, int j) {
        return i - j;
    }

    public static int multiply(int i, int j) {
        return i * j;
    }

    public static int divide(int i, int j) {
        if (j == 0) {
            throw new IllegalArgumentException("Нельзя делить на ноль");
        }
        return i / j;
    }
}
