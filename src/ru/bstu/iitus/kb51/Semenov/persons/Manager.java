package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.StrategyReader;


public class Manager extends Person {
    String job;

    public Manager() throws FatalInvalidInput {
        super();
    }

    void init() throws FatalInvalidInput {
        super.init();
        job = (String)reader.readParams(ParametersType.JOB);
    }
}

