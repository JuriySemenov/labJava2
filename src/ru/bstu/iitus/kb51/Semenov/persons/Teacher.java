package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;


public class Teacher extends Manager {
    String subject;
    String certificate;

    public Teacher(int age, String name) throws ThreeInvalidInput {
        super(age, name);
    }

    void init() {
        super.init();
        subject = Reader.readString("Преподаваемый предмет");
        certificate = Reader.readString("Номер сертификата преподователя");
    }
}

