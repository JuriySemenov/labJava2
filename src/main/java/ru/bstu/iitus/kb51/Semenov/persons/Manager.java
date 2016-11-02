package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;


public class Manager extends Person {
    String job;


    public void init() throws FatalInvalidInput {
        super.init();
        job = (String)strategy.readParams(ParametersType.JOB);
    }
}

