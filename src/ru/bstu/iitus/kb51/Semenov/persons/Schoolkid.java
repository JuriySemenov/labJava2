package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.exception.invalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;

import javax.transaction.TransactionRequiredException;


public class Schoolkid extends Person {
    float averageMark;
    int clas;

    public Schoolkid(int age, String name) throws ThreeInvalidInput{
        super(age, name);
    }

    void init() throws ThreeInvalidInput {
        clas = Reader.readInt("Класс школьника");
        averageMark = Reader.readFloat("Средний балл");
    }
}

