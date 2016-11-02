package ru.bstu.iitus.kb51.Semenov.io.write;

import ru.bstu.iitus.kb51.Semenov.io.StrategyIO;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.IOException;

/**
 * Created by User on 09.10.2016.
 */
public interface  StrategyWriter extends StrategyIO {
    void WritePerson(Person p) throws IOException;
}
