package ru.java.mifi.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSumPositiveNumbers() {
        // Arrange
        int a = 5;
        int b = 7;

        // Act
        int result = Calculator.add(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testNegativeZeroNmbers() {
        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.divide(10, 0);
        });
    }
}