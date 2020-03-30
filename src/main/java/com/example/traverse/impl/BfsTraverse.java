package com.example.traverse.impl;

import com.example.model.Graph;
import com.example.traverse.AbstractTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BfsTraverse<T> extends AbstractTraverse<T> {
    BfsTraverse(Graph<T> graph) {
        super(graph);
    }

    @Override
    public List<T> traverse(T fromVertex) {
        List<T> visits = new ArrayList<>();
        Map<T, Boolean> visitedVertices = getVisitedVertices();
        visitedVertices.put(fromVertex, true);
        visits.add(fromVertex);

        Queue<T> queue = new LinkedList<>();
        queue.add(fromVertex);

        while (!queue.isEmpty()) {
            fromVertex = queue.poll();
            List<T> adjacency = getAdjacentVertices(fromVertex);
            adjacency.forEach(adj -> {
                if (!visitedVertices.get(adj)) {
                    visitedVertices.put(adj, true);
                    queue.add(adj);
                    visits.add(adj);
                }
            });
        }
        return visits;
    }
}
