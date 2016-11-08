package ru.bstu.iitus.kb51.Semenov.io.read;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;


public class BinaryFileReader implements StrategyReader {

    public BinaryFileReader(Object o) throws IOException {
        initStrategy(o);
    }
    private ObjectInputStream reader;
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
            return (Person)reader.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> readPersons() throws FatalInvalidInput {
        LinkedList<Person> persons;
        persons=new LinkedList<>();
        try {Person p;
            int size =(int)reader.readObject();
            for(int i=0;i<size;i++){
                p = (Person) reader.readObject();
                persons.add(p);
        }
            return persons;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
