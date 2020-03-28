package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;

@Data
@RequiredArgsConstructor
public class City implements Comparator<City> {
    private final int id;

    @EqualsAndHashCode.Exclude
    private final String name;

    @Override
    public int compare(City o1, City o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
