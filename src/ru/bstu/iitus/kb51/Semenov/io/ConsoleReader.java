package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.enums.PersonType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.exception.invalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleReader implements StrategyReader {
    private static Scanner scan;

    public ConsoleReader() {
        initStrategy(System.in);
    }

   private int readInt(String text) throws FatalInvalidInput {
        int k = 0;
        try {
            System.out.println(text);
            if (scan.hasNextInt()) {
                k = scan.nextInt();
                scan.nextLine();
            } else throw new invalidInput("Требуется целое число");
        } catch (invalidInput e) {
            scan.nextLine();
            System.out.println(e.toString());
            k = readInt(text);
        }
        invalidInput.setZero();
        return k;
    }

    private  String readString(String text) {
        System.out.println(text);
        return scan.nextLine();
    }

    private double readDouble(String text) throws FatalInvalidInput {
        double k = 0;
        try {
            System.out.println(text);
            if (scan.hasNextFloat()) {
                k = scan.nextFloat();
                scan.nextLine();
            } else throw new invalidInput("Требуется ввод десятичной дроби");
        } catch (invalidInput e) {
            scan.nextLine();
            System.out.println(e.toString());
            k = readDouble(text);
        }
        invalidInput.setZero();
        return k;
    }

    private  long readLong(String text) throws FatalInvalidInput {
        long k = 0;
        try {
            System.out.println(text);
            if (scan.hasNextLong()) {
                k = scan.nextLong();
                scan.nextLine();
            } else {
                throw new invalidInput("Требуется целое число");
            }
        } catch (invalidInput e) {
            scan.nextLine();
            System.out.println(e.toString());
            k = readLong(text);
        }
        invalidInput.setZero();
        return k;
    }

    private PersonType readType(String text) throws FatalInvalidInput {
        PersonType type = null;
        try {
            System.out.println(text);
            type = PersonType.valueOf((scan.nextInt()));
            scan.nextLine();
        } catch (invalidInput e) {
            System.out.println(e.toString());
        }
        invalidInput.setZero();
        return type;
    }
    private Object next(ParametersType type) throws FatalInvalidInput {
        switch (type.getCl()){
            case ("String"): return readString(type.getConsoleText());
            case ("Double"): return readDouble(type.getConsoleText());
            case ("Integer"): return readInt(type.getConsoleText());
            case ("Long"): return readLong(type.getConsoleText());
        }
        throw new FatalInvalidInput("");
    }
@Override
    public Object readParams(ParametersType type) throws FatalInvalidInput {
        Object o = next(type);
        return  o;
    }
    @Override
    public LinkedList<Person> readPersons() throws FatalInvalidInput {

        int n = readInt("Введите кол-во человек");
        LinkedList<Person> pr = new LinkedList<Person>();
        for(int i=0;i<n;i++) {
            PersonType type = readType("Введите тип \n1-Student\n2-Teacher\n3-Schoollkid\n4-Director");
            Person p = (Person) type.getInstance();
            pr.add(p);
        }
        return pr;
    }

    @Override
    public  void initStrategy(Object in) {
        ConsoleReader.scan = new Scanner((InputStream)in);
    }
}
