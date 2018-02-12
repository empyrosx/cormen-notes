package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Stack;

/**
 * Stack implementation based on SingleLinkedList.
 * @param <T> generic element type
 *
 * All operations have O(1)
 */
public class StackBySingleLinkedList<T> implements Stack<T> {

    private SingleLinkedList<T> sll;

    public StackBySingleLinkedList() {
        sll = new SingleLinkedList<>();
    }

    @Override
    public void push(T element) {
        sll.add(element);
    }

    @Override
    public T pop() {
        T result = sll.head();
        if (result != null) {
            sll.delete(result);
        }
        return result;
    }

    @Override
    public T top() {
        return sll.head();
    }

    @Override
    public boolean isEmpty() {
        return sll.head() == null;
    }

    @Override
    public int size() {
        return sll.size();
    }
}
