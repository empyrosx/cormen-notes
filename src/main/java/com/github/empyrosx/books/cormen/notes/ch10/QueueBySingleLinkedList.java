package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Queue;

/**
 * Queue implementation based on SingleLinkedList.
 *
 * @param <T> generic element type
 *
 * All operations have O(1)
 */
public class QueueBySingleLinkedList<T> implements Queue<T> {

    private SingleLinkedNode<T> head;
    private SingleLinkedNode<T> tail;

    @Override
    public void enqueue(T element) {
        if (head == null) {
            head = tail = new SingleLinkedNode<>(element, null);
        } else {
            tail.next = new SingleLinkedNode<>(element, null);
            tail = tail.next;
        }
    }

    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T result = head.key;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return result;
    }

    @Override
    public T peek() {
        return head != null ? head.key : null;
    }

    @Override
    public int size() {
        int result = 0;
        SingleLinkedNode<T> n = head;
        while (n != null) {
            result++;
            n = n.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return "QueueBySingleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
