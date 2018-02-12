package com.github.empyrosx.books.cormen.notes.ch10;

class SingleLinkedNode<T> {

    SingleLinkedNode<T> next;
    T key;

    SingleLinkedNode(T key, SingleLinkedNode<T> next) {
        this.key = key;
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleLinkedNode{" +
                "next=" + next +
                ", key=" + key +
                '}';
    }
}
