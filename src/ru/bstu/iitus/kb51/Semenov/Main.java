package ru.bstu.iitus.kb51.Semenov;

import ru.bstu.iitus.kb51.Semenov.Compares.StudentRecordNumberComparator;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.ConsoleReader;
import ru.bstu.iitus.kb51.Semenov.persons.Person;
import ru.bstu.iitus.kb51.Semenov.persons.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static LinkedList<Person> pr;
    static ConsoleReader reader;

    static Person findMin(LinkedList<Person> pr) {
        return Collections.min(pr);
    }

    static Student findMinRecordBook(LinkedList<Person> pr) {
        List<Student> onlyStudent = pr.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .collect(Collectors.toList());
        Collections.sort(onlyStudent, new StudentRecordNumberComparator());
        return onlyStudent.isEmpty() ? null : onlyStudent.get(0);
    }

    public static void main(String[] args) {
        try {
            reader = new ConsoleReader();
            Person.setReader(reader);
            pr = reader.readPersons();
            System.out.println("Минимальный возраст у " + findMin(pr));
            System.out.println("Минимальный номер зачетки у студента " + findMinRecordBook(pr));

        } catch (FatalInvalidInput e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
