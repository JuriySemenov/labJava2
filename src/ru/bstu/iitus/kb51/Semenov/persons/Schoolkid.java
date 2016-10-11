package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.StrategyReader;


public class Schoolkid extends Person {
    double averageMark;
    int clas;

    public Schoolkid() throws FatalInvalidInput {
        super();
    }

    void init() throws FatalInvalidInput {
        super.init();
        clas = (Integer)reader.readParams(ParametersType.CLASS);
        averageMark = (Double)reader.readParams(ParametersType.AVERAGE_MARk);
    }
}

