package ru.mos.qa.testtasks;

public class Stack {
  private int mSize;
  private int[] stackArray;
  private int top;

  public Stack(int m) {
    this.mSize = m;
    stackArray = new int[mSize];
    top = -1;
  }

  public void addElement(int element) {
    if (isFull()) {
      throw new IllegalStateException("Stack is full");
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
    return deletedElement;
  }

  public int readTop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stackArray[top];

  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == mSize - 1);
  }
}
