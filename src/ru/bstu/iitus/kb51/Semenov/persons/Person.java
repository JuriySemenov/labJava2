package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;

public abstract class Person implements Comparable<Person> {
    private int age;
    private String name;

    Person() throws ThreeInvalidInput {
        init();
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }

    void init() throws ThreeInvalidInput {
        name = Reader.readString("Введите имя");
        age = Reader.readInt("Введите возраст");
    }

    @Override
    public int compareTo(Person p) {
        return age - p.age;
    }

}

