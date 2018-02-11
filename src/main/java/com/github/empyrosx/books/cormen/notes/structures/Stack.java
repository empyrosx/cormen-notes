package com.github.empyrosx.books.cormen.notes.structures;

/**
 * Common interface for any stack implementation.
 * @param <T> generic element type
 */
public interface Stack<T> {

    /**
     * Adds element on top of the stack.
     * @param element new element
     */
    void push(T element);

    /**
     * Removes element from stack.
     * @return last added element
     */
    T pop();

    /**
     * Returns element in top of the stack.
     */
    T top();

    /**
     * Checks whether stack empty or not.
     * @return true if stack is empty.
     */
    boolean isEmpty();

    /**
     * Returns size of this stack.
     */
    int size();
}
