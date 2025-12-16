package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(3, 5);
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(6, 3);
        assertEquals(18, result);
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }
}