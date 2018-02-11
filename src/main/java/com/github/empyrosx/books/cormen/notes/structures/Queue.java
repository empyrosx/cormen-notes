package com.github.empyrosx.books.cormen.notes.structures;

/**
 * Common interface for any queue implementation.
 * @param <T> generic element type
 */

public interface Queue<T> {

    /**
     * Insert element at the tail of this queue.
     * @param element the element to add
     */
    void enqueue(T element);

    /**
     * Removes the first element of this queue.
     */
    T dequeue();

    /**
     * Returns the number of elements of this queue.
     */
    int size();
}
