package ru.bstu.iitus.kb51.Semenov.Compares;

import ru.bstu.iitus.kb51.Semenov.persons.Student;

import java.util.Comparator;

public class StudentRecordNumberComparator implements Comparator<Student> {

    @Override
    public int compare(Student p1, Student p2) {
        return Student.compare(p1, p2);
    }
}
