package ru.bstu.iitus.kb51.Semenov.Compares;

import ru.bstu.iitus.kb51.Semenov.persons.Person;
import ru.bstu.iitus.kb51.Semenov.persons.Student;

import java.util.Comparator;

public class SortedByRecord implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        Student s1, s2;
        if (p1.getClass() == Student.class) {
            if (p2.getClass() == Student.class) {
                s1 = (Student) p1;
                s2 = (Student) p2;
                return Student.compare(s1,s2);
            }
            return -1;
        }
        return 1;
    }
}
