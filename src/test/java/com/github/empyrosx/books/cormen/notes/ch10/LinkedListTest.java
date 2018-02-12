package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testAdd() {
        List<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertEquals(3, list.size());
    }

    @Test
    void testDelete() {
        List<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete("Three");
        list.delete("One");
        list.delete("Two");
        assertEquals(0, list.size());

    }
}