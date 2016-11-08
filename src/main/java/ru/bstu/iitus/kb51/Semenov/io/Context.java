package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.read.StrategyReader;
import ru.bstu.iitus.kb51.Semenov.io.write.StrategyWriter;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.IOException;
import java.util.List;


public class Context {
    public Context() {
    }
    private StrategyReader reader;
    private StrategyWriter writer;


     public void setStrategyReader(StrategyReader reader) {this.reader = reader;}

     public void setStrategyWriter(StrategyWriter writer){this.writer=writer; }

     public List<Person> readPersons() throws FatalInvalidInput{
        return reader.readPersons();
    }

     public Object readParams(ParametersType type) throws FatalInvalidInput{
        return reader.readParams(type);
    }

    public void writePersons(List<Person> persons) throws IOException {
        writer.WritePersons(persons);
    }

}
