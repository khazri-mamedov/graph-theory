package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class City implements Comparable<City> {
    private final int id;

    @EqualsAndHashCode.Exclude
    private final String name;

    @Override
    public int compareTo(City city) {
        return Integer.compare(getId(), city.getId());
    }
}
