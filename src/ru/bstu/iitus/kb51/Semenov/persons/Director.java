package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;

public class Director extends Manager {
    String inn;

    public Director() throws ThreeInvalidInput {
        super();
    }

    void init() throws ThreeInvalidInput {
        super.init();
        inn = Reader.readString("Введите ИНН");
    }
}

