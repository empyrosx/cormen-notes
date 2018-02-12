package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Stack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTests {

    private static Stream<Stack<String>> createStacks() {
        return Stream.of(
                new ArrayStack<>(),
                new StackByTwoQueues<>(),
                new StackBySingleLinkedList<>()
        );
    }

    @ParameterizedTest
    @MethodSource(value = "createStacks")
    void testEmpty(Stack<String> stack) {
        assertEquals(true, stack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource(value = "createStacks")
    void testPush(Stack<String>  stack) {
        stack.push("A");
        stack.push("B");
        assertEquals(false, stack.isEmpty());
        assertEquals("B", stack.top());
    }

    @ParameterizedTest
    @MethodSource(value = "createStacks")
    void testPop(Stack<String>  stack) {
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(true, stack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource(value = "createStacks")
    void testExtendability(Stack<String>  stack) {
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