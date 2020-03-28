package com.example.traverse.impl;

import com.example.model.Graph;
import com.example.traverse.AbstractTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DfsTraverse<T> extends AbstractTraverse<T> {
    private Map<T, Boolean> visitedVertices;
    private List<T> visits = new ArrayList<>();

    DfsTraverse(Graph<T> graph) {
        super(graph);
        this.visitedVertices = getVisitedVertices();
    }

    @Override
    public List<T> traverse(T fromVertex) {
        visitedVertices.put(fromVertex, true);
        visits.add(fromVertex);

        LinkedList<T> queue = new LinkedList<>();
        queue.add(fromVertex);

        while (!queue.isEmpty()) {
            fromVertex = queue.poll();
            List<T> adjacency = getAdjacentVertices(fromVertex);
            adjacency.forEach(adj -> {
                if (!visitedVertices.get(adj)) {
                    traverse(adj);
                }
            });
        }
        return visits;
    }
}
