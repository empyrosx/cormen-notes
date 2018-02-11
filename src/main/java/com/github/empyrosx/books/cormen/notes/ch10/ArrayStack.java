package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Stack implementation based on simple array.
 */
public class ArrayStack<T> implements Stack<T> {

    private Object[] items;
    private int top;

    public ArrayStack() {
        this.items = new Object[4];
        top = -1;
    }

    public void push(T element) {
        if (top >= items.length - 1) {
            Object[] newItems = new Object[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
        top++;
        items[top] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        top--;
        return (T) items[top + 1];
    }

    @SuppressWarnings("unchecked")
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) items[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "items=" + Arrays.toString(items) +
                ", top=" + top +
                '}';
    }
}
