package ru.java.mifi.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumCalculatorTest {

    @Test
    public void testSumPositiveNumbers() {
        // Arrange
        int a = 5;
        int b = 7;
        SumCalculator calculator = new SumCalculator();

        // Act
        int result = calculator.sum(a, b);

        // Assert
        assertEquals(12, result);
    }
}