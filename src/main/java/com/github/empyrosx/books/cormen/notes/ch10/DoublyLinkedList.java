package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.List;

/**
 * Doubly-linked list implementation.
 * <p>
 * add()          = O(1)
 * <p>
 * deleteByNode() = O(1)
 * <p>
 * delete()       = O(n), because we must find element by key
 * <p>
 * size      = O(n), because we must iterate all elements to count
 * (can be optimized with additional counter)
 *
 * @param <T> generic element type
 */
public class DoublyLinkedList<T> implements List<T> {

    private Node<T> head;

    @Override
    public void add(T key) {
        Node<T> oldHead = head;
        head = new Node<>(key, null, oldHead);
        if (oldHead != null) {
            oldHead.prev = head;
        }
    }

    @Override
    public void delete(T key) {
        Node<T> node = findNode(key);
        deleteByNode(node);
    }

    private void deleteByNode(Node<T> node) {
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

    @Override
    public T head() {
        return head != null ? head.key : null;
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

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T key;

        private Node(T key, Node<T> prev, Node<T> next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", next=" + next +
                    ", key=" + key +
                    '}';
        }
    }
}
