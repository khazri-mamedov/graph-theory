package com.example.traverse.impl;

import com.example.model.City;
import com.example.model.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DfsTraverseTest {
    private City madrid;
    private City baku;
    private City minsk;
    private City moscow;

    private DfsTraverse<City> dfsTraverse;

    @Before
    public void setUp() {
        madrid = new City(1, "Madrid");
        baku = new City(2, "Baku");
        minsk = new City(3, "Minsk");
        moscow = new City(4, "Moscow");

        Graph<City> graph = new Graph<>(Arrays.asList(madrid, baku, minsk, moscow));
        graph.addEdge(madrid, baku);
        graph.addEdge(baku, moscow);
        graph.addEdge(madrid, minsk);
        graph.addEdge(moscow, moscow);

        dfsTraverse = new DfsTraverse<>(graph);
    }

    @Test
    public void testDfsTraverseRoot() {
        List<City> visits = dfsTraverse.traverse(madrid);

        assertEquals(visits.get(0), madrid);
        assertEquals(visits.get(1), baku);
        assertEquals(visits.get(2), moscow);
        assertEquals(visits.get(3), minsk);
    }

    @Test
    public void testDfsTraverseRandom() {
        List<City> visits = dfsTraverse.traverse(baku);

        assertEquals(visits.get(0), baku);
        assertEquals(visits.get(1), moscow);
    }

    @Test
    public void testDfsTraverseLeafNode() {
        List<City> visits = dfsTraverse.traverse(moscow);

        assertEquals(visits.size(), 1);
        assertEquals(visits.get(0), moscow);
    }
}
