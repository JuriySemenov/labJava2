package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;

public abstract class Person implements Comparable<Person> {
    private int age;
    private String name;

    Person(int age, String name) throws ThreeInvalidInput {
        this.age = age;
        this.name = name;
        init();
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }

    abstract void init() throws ThreeInvalidInput;

    @Override
    public int compareTo(Person p) {
        return age - p.age;
    }

}

