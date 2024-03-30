package com.griesba.algo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bunny implements Comparable<Bunny> {

    private String gender;
    private double weight;

    @Override
    public int compareTo(Bunny other) {
        if (weight == other.weight) {
            return gender.compareTo(other.gender);
        }
        return (int) (weight - other.getWeight());
    }
}
