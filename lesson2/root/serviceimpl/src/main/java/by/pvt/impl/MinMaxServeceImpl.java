package by.pvt.impl;

import by.pvt.MinMaxService;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;


public class MinMaxServeceImpl implements MinMaxService {

    public Integer findMin(List<Integer> values) {
        if(values == null || values.isEmpty()) throw new IllegalArgumentException("Input value can't null or empty!");

        OptionalInt min = values.stream()
                .filter(Objects::nonNull)
                .mapToInt(value -> value)
                .min();

        return min.getAsInt();
    }

    public Integer findMax(List<Integer> values) {

        OptionalInt max = values.stream()
                .filter(Objects::nonNull)
                .mapToInt(value -> value)
                .max();

        return max.getAsInt();
    }
}
