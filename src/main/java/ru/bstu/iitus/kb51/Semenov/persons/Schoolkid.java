package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;


public class Schoolkid extends Person {
    double averageMark;
    String clas;



    public void init() throws FatalInvalidInput {
        super.init();
        clas = strategy.readParams(ParametersType.CLASS).toString();
        if (strategy.readParams(ParametersType.AVERAGE_MARk) != null)
            averageMark = Double.parseDouble(strategy.readParams(ParametersType.AVERAGE_MARk).toString());
        else averageMark = 0;
    }
}

