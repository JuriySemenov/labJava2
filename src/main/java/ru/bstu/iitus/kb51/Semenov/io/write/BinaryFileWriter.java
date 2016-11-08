package ru.bstu.iitus.kb51.Semenov.io.write;

import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


public class BinaryFileWriter implements StrategyWriter
{
    public BinaryFileWriter(Object o) throws IOException {
        initStrategy(o);
    }
    private ObjectOutputStream writer;

    private void WritePerson(Person p) throws IOException {
        writer.writeObject(p);
    }
    @Override
    public void WritePersons(List<Person> persons) throws IOException {
        writer.writeObject(persons.size());
        for (Person p:persons) {
            WritePerson(p);
        }
    }
    @Override
    public void initStrategy(Object io) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(io.toString()));
    }
}
