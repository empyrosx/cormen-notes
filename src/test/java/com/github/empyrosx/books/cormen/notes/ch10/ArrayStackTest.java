package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayStackTest {

    @Test
    void testEmpty() {
        Stack stack = new ArrayStack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testPush() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("A");
        stack.push("B");
        assertEquals(false, stack.isEmpty());
        assertEquals("B", stack.top());
    }

    @Test
    void testPop() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testExtendability() {
        Stack<String> stack = new ArrayStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertEquals("E", stack.pop());
        assertEquals("D", stack.pop());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }
}