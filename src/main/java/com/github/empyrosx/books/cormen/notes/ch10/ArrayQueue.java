package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Queue;

import java.util.Arrays;

/**
 * Queue implementation based on simple array.
 */
public class ArrayQueue<T> implements Queue<T> {

    protected Object[] items;
    protected int head;
    protected int tail;

    public ArrayQueue() {
        this.items = new Object[4];
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(T element) {
        items[tail] = element;
        tail = (tail + 1) % items.length;

        if (head == tail) {
            doubleSizeItems();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        T result = (T) items[head];
        if (result == null) {
            return null;
        }

        items[head] = null;
        head = (head + 1) % items.length;
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) items[head];
    }

    @Override
    public int size() {
        return (items.length + tail - head) % items.length;
    }

    protected void doubleSizeItems() {
        // increase queue size
        Object[] newItems = new Object[items.length * 2];

        // from head to the end
        System.arraycopy(items, head, newItems, 0, items.length - head);
        // from 0 to the tail
        System.arraycopy(items, 0, newItems, items.length - head, tail);

        head = 0;
        tail = items.length;
        items = newItems;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
