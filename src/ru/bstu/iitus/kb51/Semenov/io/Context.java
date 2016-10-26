package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by User on 17.10.2016.
 */
public class Context {
    public Context() {
    }
    static Map<String,Object> params;
    StrategyReader reader;
    StrategyWriter writer;
    public void setStrategyReader(StrategyReader reader) {
        this.reader = reader;
    }
    public void setStrategyWriter(StrategyWriter writer){
        this.writer=writer;
    }
    public LinkedList<Person> readPersons() throws FatalInvalidInput{
        return reader.readPersons();
    }
    public Object readParams(ParametersType type) throws FatalInvalidInput{
        return reader.readParams(type);
    }
    public void setContext(Map<String,Object> params)
    {
        this.params=params;
    }
    public static Object getParam(String key){
        return params.get(key);
    }
}
