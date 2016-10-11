package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.File;
import java.io.Reader;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * Created by User on 10.10.2016.
 */
public class FileReader implements StrategyReader
{
    private File file;
    private Reader reader;



    @Override
    public Object readParams(ParametersType type) throws FatalInvalidInput {
        return null;
    }

    @Override
    public LinkedList<Person> readPersons() throws FatalInvalidInput {
        return null;
    }


    @Override
    public void initStrategy(Object io) {

    }
}
