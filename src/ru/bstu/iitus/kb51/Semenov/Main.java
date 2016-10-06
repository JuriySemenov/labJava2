package ru.bstu.iitus.kb51.Semenov;
import java.util.Arrays;
import java.util.Scanner;

import ru.bstu.iitus.kb51.Semenov.Compares.SortedByRecord;
import ru.bstu.iitus.kb51.Semenov.enums.PersonType;
import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Reader;
import ru.bstu.iitus.kb51.Semenov.persons.*;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static Person[] pr;

    static Person createPerson(PersonType type) throws ThreeInvalidInput {
        switch (type) {
            case StudentType:
                return new Student();
            case TeacherType:
                return new Teacher();
            case SchoolkidType:
                return new Schoolkid();
            case DirectorType:
                return new Director();
        }
        return null;
    }

    static Person readPerson() throws ThreeInvalidInput {
        PersonType type = Reader.readType("Введите тип \n1-Student\n2-Teacher\n3-Schoollkid\n4-Director");
        Person p = createPerson(type);
        return p;
    }

    static Person findMin(Person pr[]) {
        Arrays.sort(pr);
        return pr[0];
    }

    static Student findMinRecordBook(Person pr[]) {
        Arrays.sort(pr,new SortedByRecord());
        if(pr[0].getClass()==Student.class)
         return (Student)pr[0];
        return null;
    }

    public static void main(String[] args) {
        try {
            Reader.init(scan);
            int count = 0;
            count = Reader.readInt("Введите кол-во человек");
            pr = new Person[count];

            for (int i = 0; i < count; i++) {
                pr[i] = readPerson();
            }
            System.out.println("Минимальный возраст у " + findMin(pr));
            System.out.println("Минимальный номер зачетки у студента " + findMinRecordBook(pr));

        } catch (ThreeInvalidInput e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
