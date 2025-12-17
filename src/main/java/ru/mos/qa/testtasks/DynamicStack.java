package ru.mos.qa.testtasks;

import java.util.Arrays;

public class DynamicStack {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.5;
    private static final int GROWTH_FACTOR = 2;

    private int[] stackArray;
    private int top;
    private int initialCapacity;

    public DynamicStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public DynamicStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.initialCapacity = initialCapacity;
        this.stackArray = new int[initialCapacity];
        this.top = -1;
    }

    public void addElement(int element) {
        if (isFull()) {
            resize(stackArray.length * GROWTH_FACTOR);
        }
        stackArray[++top] = element;
    }

    public int deleteElement() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int deletedElement = readTop();
        stackArray[top] = 0;
        top -= 1;

        if (top + 1 < stackArray.length * LOAD_FACTOR && stackArray.length > initialCapacity) {
            int newSize = Math.max(initialCapacity, stackArray.length / GROWTH_FACTOR);
            resize(newSize);
        }

        return deletedElement;
    }

    public int readTop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackArray.length - 1;
    }

    public int capacity() {
        return stackArray.length;
    }

    private void resize(int newCapacity) {
        stackArray = Arrays.copyOf(stackArray, newCapacity);
    }

    public int size() {
        return top + 1;
    }

}
