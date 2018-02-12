package com.github.empyrosx.books.cormen.notes.ch10;

import com.github.empyrosx.books.cormen.notes.structures.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListTests {

    private static Stream<List<String>> createLists() {
        return Stream.of(new DoublyLinkedList<>(), new SingleLinkedList<>());
    }

    @ParameterizedTest
    @MethodSource(value = "createLists")
    void testAdd(List<String> list) {
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertEquals(3, list.size());
    }

    @ParameterizedTest
    @MethodSource(value = "createLists")
    void testDelete(List<String> list) {
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.delete("Three");
        list.delete("One");
        list.delete("Two");
        assertEquals(0, list.size());
    }
}