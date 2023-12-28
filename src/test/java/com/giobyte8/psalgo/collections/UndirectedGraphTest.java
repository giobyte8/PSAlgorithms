package com.giobyte8.psalgo.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    @Test
    void addVertex() {
        Graph<Character> graph = new UndirectedGraph<>();
        assertEquals(0, graph.size());

        graph.add('A');
        assertEquals(1, graph.size());
        assertTrue(graph.contains('A'));
    }

    @Test
    void addVertices() {
        Graph<Character> graph = new UndirectedGraph<>();

        Character[] chars = {'A', 'B', 'C', 'D', 'E'};
        graph.addAll(chars);

        assertEquals(5, graph.size());
        Arrays.stream(chars).forEach(c -> assertTrue(graph.contains(c)));
    }

    @Test
    void traverseBFS() {
        Graph<Character> graph = new UndirectedGraph<>();
        graph.addAll(new Character[]{'A', 'B', 'C', 'D', 'E', 'F'});

        graph.link('A', 'C');
        graph.link('A', 'E');
        graph.link('B', 'F');
        graph.link('C', 'B');
        graph.link('C', 'D');
        graph.link('C', 'F');
        graph.link('D', 'F');
        graph.link('E', 'F');

        List<Character> traverse = graph.traverseBFS();
        assertArrayEquals(
                new Character[]{'A', 'C', 'E', 'B', 'D', 'F'},
                traverse.toArray());
    }

    @Test
    void traverseDFS() {
        Graph<Character> graph = new UndirectedGraph<>();
        graph.addAll(new Character[]{'A', 'B', 'C', 'D', 'E', 'F'});

        graph.link('A', 'C');
        graph.link('A', 'E');
        graph.link('B', 'F');
        graph.link('C', 'B');
        graph.link('C', 'D');
        graph.link('C', 'F');
        graph.link('D', 'F');
        graph.link('E', 'F');

        List<Character> traverse = graph.traverseDFS();
        assertArrayEquals(
                new Character[]{'A', 'C', 'B', 'F', 'D', 'E'},
                traverse.toArray());
    }
}