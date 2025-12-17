package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.DynamicStack;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStackTests {

    @Test
    void testConstructorWithDefaultCapacity() {
        DynamicStack stack = new DynamicStack();
        assertEquals(0, stack.size());
        assertEquals(10, stack.capacity());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testConstructorWithCustomCapacity() {
        DynamicStack stack = new DynamicStack(5);
        assertEquals(0, stack.size());
        assertEquals(5, stack.capacity());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testConstructorWithInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicStack(0));
        assertThrows(IllegalArgumentException.class, () -> new DynamicStack(-1));
    }

    @Test
    void testAddElementIncreasesSize() {
        DynamicStack stack = new DynamicStack(3);
        stack.addElement(10);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());

        stack.addElement(20);
        assertEquals(2, stack.size());

        stack.addElement(30);
        assertEquals(3, stack.size());
    }

    @Test
    void testReadTopReturnsLastElement() {
        DynamicStack stack = new DynamicStack(3);
        stack.addElement(10);
        assertEquals(10, stack.readTop());

        stack.addElement(20);
        assertEquals(20, stack.readTop());

        stack.addElement(30);
        assertEquals(30, stack.readTop());
    }

    @Test
    void testDeleteElementRemovesAndReturnsTop() {
        DynamicStack stack = new DynamicStack(3);
        stack.addElement(10);
        stack.addElement(20);
        stack.addElement(30);

        assertEquals(30, stack.deleteElement());
        assertEquals(2, stack.size());
        assertEquals(20, stack.readTop());

        assertEquals(20, stack.deleteElement());
        assertEquals(1, stack.size());
        assertEquals(10, stack.readTop());

        assertEquals(10, stack.deleteElement());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testDeleteElementFromEmptyStackThrowsException() {
        DynamicStack stack = new DynamicStack(3);
        assertThrows(IllegalStateException.class, stack::deleteElement);
    }

    @Test
    void testReadTopFromEmptyStackThrowsException() {
        DynamicStack stack = new DynamicStack(3);
        assertThrows(IllegalStateException.class, stack::readTop);
    }

    @Test
    void testDynamicExpansion() {
        DynamicStack stack = new DynamicStack(2);

        stack.addElement(1);
        stack.addElement(2);
        assertEquals(2, stack.capacity());

        stack.addElement(3);
        assertTrue(stack.capacity() > 2);
        assertEquals(3, stack.size());
        assertEquals(3, stack.readTop());

        assertEquals(3, stack.deleteElement());
        assertEquals(2, stack.deleteElement());
        assertEquals(1, stack.deleteElement());
    }

    @Test
    void testDynamicShrinking() {
        DynamicStack stack = new DynamicStack(10);

        int startCapacity = stack.capacity();

        for (int i = 0; i < 20; i++) {
            stack.addElement(i);
        }

        int initialCapacity = stack.capacity();

        while (stack.size() > 10) {
            stack.deleteElement();
        }

        assertTrue(startCapacity < initialCapacity);
    }

    @Test
    void testStackNeverShrinksBelowInitialCapacity() {
        DynamicStack stack = new DynamicStack(5);

        for (int i = 0; i < 10; i++) {
            stack.addElement(i);
        }

        while (!stack.isEmpty()) {
            stack.deleteElement();
        }

        assertEquals(5, stack.capacity());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testMultipleExpansionsAndShrinks() {
        DynamicStack stack = new DynamicStack(2);

        for (int i = 0; i < 100; i++) {
            stack.addElement(i);
        }

        assertEquals(100, stack.size());

        for (int i = 99; i >= 0; i--) {
            assertEquals(i, stack.deleteElement());
        }

        assertTrue(stack.isEmpty());
        assertEquals(2, stack.capacity());
    }

    @Test
    void testIsFull() {
        DynamicStack stack = new DynamicStack(3);
        assertFalse(stack.isFull());

        stack.addElement(1);
        assertFalse(stack.isFull());

        stack.addElement(2);
        assertFalse(stack.isFull());

        stack.addElement(3);
        assertTrue(stack.isFull());

        stack.addElement(4);
        assertFalse(stack.isFull());
    }

    @Test
    void testComplexScenario() {
        DynamicStack stack = new DynamicStack(4);

        stack.addElement(1);
        stack.addElement(2);
        stack.addElement(3);

        assertEquals(3, stack.deleteElement());

        stack.addElement(4);
        stack.addElement(5);

        assertEquals(4, stack.size());
        assertEquals(5, stack.readTop());

        assertEquals(5, stack.deleteElement());
        assertEquals(4, stack.deleteElement());
        assertEquals(2, stack.deleteElement());
        assertEquals(1, stack.deleteElement());

        assertTrue(stack.isEmpty());
    }
}