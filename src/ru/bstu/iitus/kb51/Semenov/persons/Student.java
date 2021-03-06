package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.StrategyReader;

public class Student extends Person {
    Long recordBook;
    Double averageMark;
    String group;


    public void init() throws FatalInvalidInput {
        super.init();
        group = (String) strategy.readParams(ParametersType.GROUP);
        averageMark= (Double) strategy.readParams(ParametersType.AVERAGE_MARk);
        recordBook = (Long)strategy.readParams(ParametersType.RECORD_BOOK);
    }
    public static int compare(Student s1,Student s2){
      return  s1.recordBook.compareTo(s2.recordBook);
    }
}

