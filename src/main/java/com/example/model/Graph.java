package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class Graph<T> {
    @Getter
    private final List<T> vertices;

    @Getter
    private final Map<T, List<T>> adjacency;

    public Graph(List<T> vertices) {
        this.vertices = vertices;
        this.adjacency = new HashMap<>();

        vertices.forEach(model -> adjacency.put(model, new ArrayList<>()));
    }

    public void addEdge(T fromModel, T toModel) {
        adjacency.get(fromModel).add(toModel);
    }
}
