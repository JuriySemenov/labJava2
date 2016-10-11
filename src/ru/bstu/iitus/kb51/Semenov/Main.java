package ru.bstu.iitus.kb51.Semenov;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


import ru.bstu.iitus.kb51.Semenov.Compares.SortedByRecord;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.ConsoleReader;
import ru.bstu.iitus.kb51.Semenov.persons.*;


public class Main {
    static LinkedList<Person> pr;
    static ConsoleReader reader;

    static Person findMin(LinkedList<Person> pr) {
       return Collections.min(pr);
    }

    static Student findMinRecordBook(LinkedList<Person> pr) {
        Collections.sort(pr,new SortedByRecord());
        if(pr.get(0).getClass()==Student.class)
         return (Student)pr.get(0);
        return null;
    }

    public static void main(String[] args) {
        try {
            reader = new ConsoleReader((Object)System.in);
            Person.setReader(reader);
            pr=reader.readPersons();
            System.out.println("Минимальный возраст у " + findMin(pr));
            System.out.println("Минимальный номер зачетки у студента " + findMinRecordBook(pr));

        } catch (FatalInvalidInput e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
