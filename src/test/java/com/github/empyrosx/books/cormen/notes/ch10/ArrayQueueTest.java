package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    void testEnqueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals(3, queue.size());
    }

    @Test
    void testDequeue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals("First", queue.dequeue());
        assertEquals("Second", queue.dequeue());
        assertEquals("Third", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void testCircularity() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Fourth");

        assertEquals("First", queue.dequeue());
        assertEquals("Second", queue.dequeue());

        queue.enqueue("Fifth");
        queue.enqueue("Sixth");

        assertEquals("Third", queue.dequeue());
        assertEquals("Fourth", queue.dequeue());
        assertEquals("Fifth", queue.dequeue());
        assertEquals(1, queue.size());

    }

    @Test
    void testSize() {
        Queue<String> queue = new ArrayQueue<>();
        assertEquals(0, queue.size());
        queue.enqueue("First");
        assertEquals(1, queue.size());
        queue.enqueue("Second");
        assertEquals(2, queue.size());
        queue.enqueue("Third");
        assertEquals(3, queue.size());
        queue.enqueue("Fourth");
        assertEquals(4, queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    void testExtendability() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals("One", queue.dequeue());

        queue.enqueue("Four");
        // after this line size should be doubled
        queue.enqueue("Five");
        queue.enqueue("Six");

        queue.enqueue("Seven");
        queue.enqueue("Eight");
        queue.enqueue("Nine");
        queue.enqueue("Ten");

        assertEquals("Two", queue.dequeue());
        assertEquals("Three", queue.dequeue());
        assertEquals("Four", queue.dequeue());
        assertEquals("Five", queue.dequeue());
        assertEquals("Six", queue.dequeue());
        assertEquals("Seven", queue.dequeue());
        assertEquals("Eight", queue.dequeue());
        assertEquals("Nine", queue.dequeue());
        assertEquals("Ten", queue.dequeue());
        assertEquals(0, queue.size());
    }
}