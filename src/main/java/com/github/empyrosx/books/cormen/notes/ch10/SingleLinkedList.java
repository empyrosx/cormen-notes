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

    private SingleLinkedNode<T> head;

    @Override
    public void add(T key) {
        head = new SingleLinkedNode<>(key, head);
    }

    @Override
    public void delete(T key) {
        SingleLinkedNode<T> node = findNode(key);
        deleteByNode(node);
    }

    private void deleteByNode(SingleLinkedNode<T> node) {
        if (node == null) {
            return;
        }

        SingleLinkedNode<T> prev = findPrevNode(node);
        if (prev != null) {
            prev.next = node.next;
        } else {
            head = node.next;
        }
    }

    private SingleLinkedNode<T> findPrevNode(SingleLinkedNode<T> node) {
        SingleLinkedNode<T> prev = head;
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
        SingleLinkedNode<T> n = head;
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

    private SingleLinkedNode<T> findNode(T key) {
        SingleLinkedNode<T> n = head;
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

}
