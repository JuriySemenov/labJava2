package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Context;


public abstract class Person implements Comparable<Person> {
    private int age;
    private String name;
    static Context strategy;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }

   public void init() throws FatalInvalidInput {
        name = (String)strategy.readParams(ParametersType.NAME);
        age = (int)strategy.readParams(ParametersType.AGE);
    }
    static public  void  setStrategy(Context strategy){
        Person.strategy=strategy;
    }
    @Override
    public int compareTo(Person p) {
        return age - p.age;
    }

}

