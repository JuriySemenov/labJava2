package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;

public class Director extends Manager {
    String inn;


    public void init() throws FatalInvalidInput {
        super.init();
        inn = (String)strategy.readParams(ParametersType.INN);
    }
}

