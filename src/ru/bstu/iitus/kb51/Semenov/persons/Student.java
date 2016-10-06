package ru.bstu.iitus.kb51.Semenov.persons;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;

public class Student extends Person {
    Long recordBook;
    float averageMark;
    String group;

    public Student() throws ThreeInvalidInput {
        super();
    }

    void init() throws ThreeInvalidInput {
        super.init();
        group = Reader.readString("Группа");
        averageMark = Reader.readFloat("Средний балл");
        recordBook = Reader.readLong("Номер зачетной книжки студента");
    }
    public static int compare(Student s1,Student s2){
      return  s1.recordBook.compareTo(s2.recordBook);
    }
}

