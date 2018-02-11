package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Queue;
import com.github.empyrosx.books.cormen.notes.structures.Stack;

public class StackByTwoQueues<T> implements Stack<T> {

    private Queue<T> main;
    private Queue<T> secondary;

    public StackByTwoQueues() {
        main = new ArrayQueue<>();
        secondary = new ArrayQueue<>();
    }

    @Override
    public void push(T element) {
        secondary.enqueue(element);
        while (main.size() > 0){
            secondary.enqueue(main.dequeue());
        }
        // change main and secondary
        Queue<T> temp = main;
        main = secondary;
        secondary = temp;
    }

    @Override
    public T pop() {
        return main.dequeue();
    }

    @Override
    public T top() {
        return main.peek();
    }

    @Override
    public boolean isEmpty() {
        return main.size() == 0;
    }

    @Override
    public int size() {
        return main.size();
    }
}
