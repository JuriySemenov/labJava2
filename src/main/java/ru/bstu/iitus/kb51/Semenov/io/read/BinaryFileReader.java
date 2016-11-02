package ru.bstu.iitus.kb51.Semenov.io.read;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 31.10.2016.
 */
public class BinaryFileReader implements StrategyReader {

    ObjectInputStream reader;
    @Override
    public void initStrategy(Object io) throws IOException {
        FileInputStream file = new FileInputStream(io.toString());
        reader = new ObjectInputStream(file);
    }

    @Override
    public Object readParams(ParametersType type) throws FatalInvalidInput {
        return null;
    }

    public Person readPerson(ParametersType type) throws FatalInvalidInput {
        try {
            Person p = (Person)reader.readObject();
            return p;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> readPersons() throws FatalInvalidInput {
        LinkedList<Person> persons;
        try {
            persons =(LinkedList<Person>)reader.readObject();
            return persons;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
