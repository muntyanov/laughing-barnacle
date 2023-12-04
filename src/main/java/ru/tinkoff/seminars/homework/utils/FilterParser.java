package ru.tinkoff.seminars.homework.utils;

import ru.tinkoff.seminars.homework.domain.Attribute;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FilterParser {
    public Collection<Attribute> parse(String filter) {
        return Arrays.stream(filter.split(",")).map(
                f -> {
                    var attrArr = f.split(":");
                    return new Attribute(attrArr[0], attrArr[1]);
                }
        ).collect(Collectors.toList());
    }
}
