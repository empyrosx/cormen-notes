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
     * @param key element to add
     */
    void add(T key);

    /**
     * Deletes element from the list.
     *
     * @param key element to delete
     */
    void delete(T key);

    /**
     * Returns size of the list.
     */
    int size();

    /**
     * Returns value of head element.
     */
    T head();
}
