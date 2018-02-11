package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Deque;

import java.util.Arrays;

/**
 * Deque implementation based on simple array.
 */
public class ArrayDeque<T> extends ArrayQueue<T> implements Deque<T> {

    @Override
    public void addFirst(T element) {
        head = (items.length + head - 1) % items.length;
        items[head] = element;

        if (head == tail) {
            doubleSizeItems();
        }
    }

    @Override
    public void addLast(T element) {
        super.enqueue(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pollFirst() {
        return super.dequeue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pollLast() {
        tail = (tail - 1) % items.length;

        T result = (T) items[tail];
        if (result == null) {
            return null;
        }

        items[tail] = null;
        return result;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "items=" + Arrays.toString(items) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
