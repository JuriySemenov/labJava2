package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;


public class Teacher extends Manager {
    String subject;
    String certificate;



    public void init() throws FatalInvalidInput {
        super.init();
        subject = (String) strategy.readParams(ParametersType.SUBJECT);
        certificate = (String) strategy.readParams(ParametersType.CERTIFICATE);

    }
}

