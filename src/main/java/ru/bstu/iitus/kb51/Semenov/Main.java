package ru.bstu.iitus.kb51.Semenov;

import ru.bstu.iitus.kb51.Semenov.compares.StudentRecordNumberComparator;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.io.Context;
import ru.bstu.iitus.kb51.Semenov.io.read.BinaryFileReader;
import ru.bstu.iitus.kb51.Semenov.io.read.ConsoleReader;
import ru.bstu.iitus.kb51.Semenov.io.read.FileReaderXML;
import ru.bstu.iitus.kb51.Semenov.io.write.BinaryFileWriter;
import ru.bstu.iitus.kb51.Semenov.persons.Person;
import ru.bstu.iitus.kb51.Semenov.persons.Student;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    private static List<Person> pr;
    private static Context strategy;

    private static Person findMin(List<Person> pr) {
        return Collections.min(pr);
    }

    private static Student findMinRecordBook(List<Person> pr) {
        List<Student> onlyStudent = pr.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .collect(Collectors.toList());
        Collections.sort(onlyStudent, new StudentRecordNumberComparator());
        return onlyStudent.isEmpty() ? null : onlyStudent.get(0);
    }

    private static void inputStrategy(){
        Scanner scan = new Scanner(System.in);
        strategy = new Context();
        System.out.println("Выберите тип ввода.\n 1-консоль.\n 2-файл.");
        if(scan.nextInt()==1){
            strategy.setStrategyReader(new ConsoleReader());
        }
        else {
            strategy.setStrategyReader(new FileReaderXML("test_data.xml"));
        }
        Person.setStrategy(strategy);
    }
    public static void main(String[] args) {
        try {
            inputStrategy();
            pr = strategy.readPersons();
            strategy.setStrategyWriter(new BinaryFileWriter("test_data_write.txt"));
            strategy.setStrategyReader(new BinaryFileReader("test_data_write.txt"));
            strategy.writePersons(pr);
            pr = strategy.readPersons();
            System.out.println("Минимальный возраст у " + findMin(pr));
            System.out.println("Минимальный номер зачетки у студента " + findMinRecordBook(pr));
        } catch (FatalInvalidInput e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
