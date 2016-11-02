package ru.bstu.iitus.kb51.Semenov.io.write;

import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by User on 01.11.2016.
 */
public class BinaryFileWriter implements StrategyWriter
{
    ObjectOutputStream writer;
    @Override
    public void WritePerson(Person p) throws IOException {
        writer.writeObject(p);
    }
    public void WritePersons(List<Person> persons) throws IOException {
        for (Person p:persons) {
            WritePerson(p);
        }
    }
    @Override
    public void initStrategy(Object io) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(io.toString()));
    }
}
