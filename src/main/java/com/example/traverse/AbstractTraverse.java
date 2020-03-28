package com.example.traverse;

import com.example.model.Graph;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class AbstractTraverse<T> implements Traverse<T> {
    protected final Graph<T> graph;

    protected Map<T, Boolean> getVisitedVertices() {
        List<T> vertices = graph.getVertices();
        Map<T, Boolean> visitedVertices = new HashMap<>();
        vertices.forEach(model -> visitedVertices.putIfAbsent(model, false));
        return visitedVertices;
    }

    protected List<T> getAdjacentVertices(T fromVertex) {
         return graph.getAdjacency().get(fromVertex);
    }
}
