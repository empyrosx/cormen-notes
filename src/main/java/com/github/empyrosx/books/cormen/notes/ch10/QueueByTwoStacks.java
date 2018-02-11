package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Queue;
import com.github.empyrosx.books.cormen.notes.structures.Stack;

public class QueueByTwoStacks<T> implements Queue<T> {

    private Stack<T> active;
    private Stack<T> temp;

    public QueueByTwoStacks() {
        active = new ArrayStack<>();
        temp = new ArrayStack<>();
    }

    @Override
    public void enqueue(T element) {
        while (!active.isEmpty()) {
            temp.push(active.pop());
        }
        active.push(element);
        while (!temp.isEmpty()) {
            active.push(temp.pop());
        }
    }

    @Override
    public T dequeue() {
        return active.pop();
    }

    @Override
    public T peek() {
        return active.top();
    }

    @Override
    public int size() {
        return active.size();
    }

    @Override
    public String toString() {
        return "QueueByTwoStacks{" +
                "active=" + active +
                ", temp=" + temp +
                '}';
    }
}
