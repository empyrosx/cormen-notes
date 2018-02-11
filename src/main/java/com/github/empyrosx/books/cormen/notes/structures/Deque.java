package com.github.empyrosx.books.cormen.notes.structures;

/**
 * Common interface for any queue implementation.
 * @param <T> generic element type
 */

public interface Deque<T> {

    /**
     * Inserts element at the head of this deque.
     * @param element the element to add
     */
    void addFirst(T element);

    /**
     * Inserts element at the tail of this deque.
     * @param element
     */
    void addLast(T element);

    /**
     * Removes the first element of this deque.
     */
    T pollFirst();

    /**
     * Removes the last element of this deque.
     */
    T pollLast();

    /**
     * Returns the number of elements of this queue.
     */
    int size();
}
