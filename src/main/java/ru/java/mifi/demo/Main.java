package ru.java.mifi.demo;

public class Main {
    public static void main(String[] args) {
        int result = Math.toIntExact(Calculator.add(2, 2));
        System.out.println(result);
    }
}
