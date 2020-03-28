package com.example.traverse;

import java.util.List;

public interface Traverse<T> {
    List<T> traverse(T source);
}
