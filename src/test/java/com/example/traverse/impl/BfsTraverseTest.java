package com.example.traverse.impl;

import com.example.model.City;
import com.example.model.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BfsTraverseTest {
    private City madrid;
    private City baku;
    private City minsk;
    private City moscow;

    private BfsTraverse<City> bfsTraverse;

    @Before
    public void setUp() {
        madrid = new City(1, "Madrid");
        baku = new City(2, "Baku");
        minsk = new City(3, "Minsk");
        moscow = new City(4, "Moscow");

        Graph<City> graph = new Graph<>(Arrays.asList(madrid, baku, minsk, moscow));
        graph.addEdge(madrid, baku);
        graph.addEdge(madrid, minsk);
        graph.addEdge(minsk, moscow);
        graph.addEdge(minsk, minsk);

        bfsTraverse = new BfsTraverse<>(graph);
    }

    @Test
    public void testBfsTraverseRoot() {
        List<City> visits = bfsTraverse.traverse(madrid);

        assertEquals(visits.get(0), madrid);
        assertEquals(visits.get(1), baku);
        assertEquals(visits.get(2), minsk);
        assertEquals(visits.get(3), moscow);
    }

    @Test
    public void testBfsTraverseRandom() {
        List<City> visits = bfsTraverse.traverse(minsk);

        assertEquals(visits.get(0), minsk);
        assertEquals(visits.get(1), moscow);
    }

    @Test
    public void testBfsTraverseLeafNode() {
        List<City> visits = bfsTraverse.traverse(moscow);

        assertEquals(visits.size(), 1);
        assertEquals(visits.get(0), moscow);
    }
}
