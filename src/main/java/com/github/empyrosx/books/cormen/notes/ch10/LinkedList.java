package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.List;

/**
 * Doubly-linked list implementation.
 *
 * add(T)    = O(1)
 *
 * delete(T) = O(n), because we must find element by key
 * (can be optimizing if we can get pointer to node without search)
 *
 * size      = O(n), because we must iterate all elements to count
 * (can be optimized with additional counter)
 *
 * @param <T> generic element type
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;

    @Override
    public void add(T element) {
        Node<T> oldHead = head;
        head = new Node<>(element, null, oldHead);
        if (oldHead != null) {
            oldHead.prev = head;
        }
    }

    @Override
    public void delete(T element) {
        Node<T> node = findNode(element);
        if (node == null) {
            return;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
    }

    @Override
    public int size() {
        int result = 0;
        Node<T> n = head;
        while (n != null) {
            result++;
            n = n.next;
        }
        return result;
    }

    private Node<T> findNode(T key) {
        Node<T> n = head;
        while (n != null) {
            if (key.equals(n.key)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }

    private static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T key;

        Node(T key, Node<T> prev, Node<T> next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
}
