package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.StrategyReader;
import ru.bstu.iitus.kb51.Semenov.io.StrategyWriter;

public abstract class Person implements Comparable<Person> {
    private int age;
    private String name;
    static StrategyReader reader;
    static StrategyWriter writer;
    public Person() throws FatalInvalidInput {
        init();
    }


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }

    void init() throws FatalInvalidInput {
        name = (String)reader.readParams(ParametersType.NAME);
        age = (int)reader.readParams(ParametersType.AGE);
    }
    static public  void  setReader(StrategyReader reader){
        Person.reader=reader;
    }
    @Override
    public int compareTo(Person p) {
        return age - p.age;
    }

}

