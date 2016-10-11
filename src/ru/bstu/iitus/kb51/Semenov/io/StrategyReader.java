package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.util.LinkedList;


/**
 * Created by User on 09.10.2016.
 */
public  interface StrategyReader extends StrategyIO {
    Object readParams(ParametersType type) throws FatalInvalidInput;
    LinkedList<Person> readPersons() throws FatalInvalidInput;
}
