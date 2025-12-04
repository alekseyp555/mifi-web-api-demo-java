//import org.junit.jupiter.api.Test;
//import ru.java.mifi.demo.Calculator;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class CalculatorTest {
//
//    @Test
//    void testCalAdd() {
//        int actual = Calculator.add(2, 2);
//        assertEquals(4, actual);
//    }
//
////    @Test
////    void testCalSubtract() {
////        int actual = Calculator.subtract(4, 2);
////        assertEquals(2, actual);
////    }
//
//    @Test
//    void testCalMultiply() {
//        int actual = Calculator.multiply(2, 2);
//        assertEquals(4, actual);
//    }
//
//    @Test
//    void testCalcTwo() {
//        int actual = Calculator.add(2, 4);
//        assertEquals(6, actual);
//    }
//
//    @Test
//    void testDivide() {
//        assertEquals(2, Calculator.divide(6, 3));
//        assertEquals(-2, Calculator.divide(-6, 3));
//
//        // Деление на ноль должно вызвать исключение ArithmeticException
//        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
//    }
//}
