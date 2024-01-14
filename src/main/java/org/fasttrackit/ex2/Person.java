package org.fasttrackit.ex2;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Person {
    private static Integer count = 1;
    private int id;
    private final String name;
    private final Integer age;

    @Builder(toBuilder = true)
    public Person(String name, Integer age) {
        this.id = count;
        this.name = name;
        this.age = age;
        count++;
    }
}
