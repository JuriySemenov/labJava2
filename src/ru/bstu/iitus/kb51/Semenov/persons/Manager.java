package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;


public class Manager extends Person {
    String job;

    public Manager() throws ThreeInvalidInput {
        super();
    }

    void init() throws ThreeInvalidInput {
        super.init();
        job = Reader.readString("Место работы");
    }
}

