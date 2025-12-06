package ru.java.mifi.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SumCalculatorRefactoredTest {

    @Test
    public void testEmptyArgumentsShouldThrowException() {
        // Акт
        Throwable exception = assertThrows(IllegalArgumentException.class,
                SumCalculatorRefactored::sum);

        // Утверждение
        assertEquals("Переданы нулевые аргументы", exception.getMessage());
    }
}