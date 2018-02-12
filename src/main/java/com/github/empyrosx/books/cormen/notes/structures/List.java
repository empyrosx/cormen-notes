package com.github.empyrosx.books.cormen.notes.structures;

/**
 * Common interface for any list implementation.
 *
 * @param <T> generic element type
 */
public interface List<T> {

    /**
     * Adds element at the head of the list.
     *
     * @param element element to add
     */
    void add(T element);

    /**
     * Deletes element from the list.
     *
     * @param element element to delete
     */
    void delete(T element);

    /**
     * Returns size of the list.
     */
    int size();
}
