package ru.bstu.iitus.kb51.Semenov.io.write;

import ru.bstu.iitus.kb51.Semenov.io.StrategyIO;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.IOException;
import java.util.List;


public interface  StrategyWriter extends StrategyIO {
    void WritePersons(List<Person> p) throws IOException;
}
