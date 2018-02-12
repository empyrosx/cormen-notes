package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.List;

/**
 * Single-linked list implementation.
 * <p>
 * add()          = O(1)
 * <p>
 * deleteByNode() = O(n), because we don't have reference to previous node and
 * we must find it by list iterating
 * <p>
 * delete()       = O(n), because we must find element by key and its previous node
 * <p>
 * size      = O(n), because we must iterate all elements to count
 * (can be optimized with additional counter)
 *
 * @param <T> generic element type
 */
public class SingleLinkedList<T> implements List<T> {

    private Node<T> head;

    @Override
    public void add(T key) {
        head = new Node<>(key, head);
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

        Node<T> prev = findPrevNode(node);
        if (prev != null) {
            prev.next = node.next;
        } else {
            head = node.next;
        }
    }

    private Node<T> findPrevNode(Node<T> node) {
        Node<T> prev = head;
        while (prev != null) {
            if (prev.next == node) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
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

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<T> {
        private Node<T> next;
        private T key;

        private Node(T key, Node<T> next) {
            this.key = key;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", key=" + key +
                    '}';
        }
    }
}
