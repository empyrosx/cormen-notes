package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Deque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeTests {

    @Test
    void testAddFirst() {
        Deque<String> queue = new ArrayDeque<>();
        queue.addFirst("First");
        queue.addFirst("Second");
        queue.addFirst("Third");

        assertEquals(3, queue.size());
    }

    @Test
    void testAddLast() {
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("First");
        queue.addLast("Second");
        queue.addLast("Third");

        assertEquals(3, queue.size());
    }

    @Test
    void testPollFirst() {
        Deque<String> queue = new ArrayDeque<>();
        queue.addFirst("First");
        queue.addFirst("Second");
        queue.addFirst("Third");

        assertEquals("Third", queue.pollFirst());
        assertEquals("Second", queue.pollFirst());
        assertEquals("First", queue.pollFirst());
        assertEquals(0, queue.size());
    }

    @Test
    void testPollLast() {
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("First");
        queue.addLast("Second");
        queue.addLast("Third");

        assertEquals("Third", queue.pollLast());
        assertEquals("Second", queue.pollLast());
        assertEquals("First", queue.pollLast());
        assertEquals(0, queue.size());
    }

    @Test
    void testCircularity() {
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("Two");
        queue.addLast("Three");
        queue.addLast("Four");
        queue.addLast("Five");

        assertEquals("Five", queue.pollLast());
        assertEquals("Two", queue.pollFirst());

        queue.addFirst("One");
        queue.addLast("Six");

        assertEquals("One", queue.pollFirst());
        assertEquals("Six", queue.pollLast());
        assertEquals("Four", queue.pollLast());
        assertEquals(1, queue.size());

    }

    @Test
    void testSize() {
        Deque<String> queue = new ArrayDeque<>();
        assertEquals(0, queue.size());
        queue.addFirst("First");
        assertEquals(1, queue.size());
        queue.addLast("Second");
        assertEquals(2, queue.size());
        queue.addLast("Third");
        assertEquals(3, queue.size());
        queue.addLast("Fourth");
        assertEquals(4, queue.size());

        queue.pollFirst();
        queue.pollLast();
        queue.pollFirst();
        assertEquals(1, queue.size());
        queue.pollLast();
        assertEquals(0, queue.size());
    }

    @Test
    void testExtendability() {
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("Two");
        queue.addLast("Three");
        queue.addLast("Four");

        assertEquals("Two", queue.pollFirst());

        queue.addFirst("One");
        // after this line size should be doubled
        queue.addFirst("Zero");
        queue.addLast("Six");

        queue.addLast("Seven");
        queue.addFirst("Minus one");
        queue.addLast("Eight");
        queue.addFirst("Minus two");

        assertEquals("Minus two", queue.pollFirst());
        assertEquals("Minus one", queue.pollFirst());
        assertEquals("Eight", queue.pollLast());
        assertEquals("Seven", queue.pollLast());
        assertEquals("Zero", queue.pollFirst());
        assertEquals("Six", queue.pollLast());
        assertEquals("Four", queue.pollLast());
        assertEquals("Three", queue.pollLast());
        assertEquals("One", queue.pollFirst());
        assertEquals(0, queue.size());
    }

}