package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.StrategyReader;


public class Teacher extends Manager {
    String subject;
    String certificate;

    public Teacher() throws FatalInvalidInput {
        super();
    }

    void init() throws FatalInvalidInput {
        super.init();
        subject = (String) reader.readParams(ParametersType.SUBJECT);
        certificate = (String) reader.readParams(ParametersType.CERTIFICATE);

    }
}

