package ru.mos.qa.testtasks.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mos.qa.testtasks.Calculator;
import ru.mos.qa.testtasks.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    private Stack stack;
    @BeforeEach
    public void setUp() {
        stack = new Stack(5);
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty(), "Новый стек должен быть пустым");
    }

    @Test
    public void testAddElement() {
        stack.addElement(10);
        assertFalse(stack.isEmpty(), "Стек не должен быть пустым после добавления элемента");
        assertEquals(10, stack.readTop(), "Вершина стека должна содержать добавленный элемент");
    }

    @Test
    public void testAddMultipleElements() {
        stack.addElement(10);
        stack.addElement(20);
        stack.addElement(30);

        assertEquals(30, stack.readTop(), "Вершина стека должна содержать последний добавленный элемент");
        assertFalse(stack.isFull(), "Стек не должен быть полным после добавления трех элементов в стек размером 5");
    }

    @Test
    public void testDeleteElement() {
        stack.addElement(10);
        stack.addElement(20);
        stack.addElement(30);

        int deleted = stack.deleteElement();
        assertEquals(30, deleted, "Удаленный элемент должен быть 30 (последним добавленным)");
        assertEquals(20, stack.readTop(), "Вершина стека должна быть 20 после удаления 30");
    }

    @Test
    public void testDeleteFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> {
            stack.deleteElement();
        }, "Удаление из пустого стека должно выбрасывать исключение");
    }

    @Test
    public void testReadTopFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> {
            stack.readTop();
        }, "Чтение вершины пустого стека должно выбрасывать исключение");
    }

    @Test
    public void testFullStack() {
        for (int i = 0; i < 5; i++) {
            stack.addElement(i * 10);
        }

        assertTrue(stack.isFull(), "Стек должен быть полным после добавления 5 элементов");

        assertEquals(40, stack.readTop(), "Вершина стека должна содержать 40");
    }

    @Test
    public void testStackWithZeroCapacity() {
        Stack zeroStack = new Stack(0);
        assertTrue(zeroStack.isEmpty(), "Стек с емкостью 0 должен быть пустым");
        assertTrue(zeroStack.isFull(), "Стек с емкостью 0 должен быть полным");

        assertThrows(IllegalStateException.class, () -> {
            zeroStack.addElement(1);
        }, "Добавление в стек с емкостью 0 должно выбрасывать исключение");
    }

}
