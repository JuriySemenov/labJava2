package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.PersonType;
import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.exception.invalidInput;

import java.util.Scanner;

public class Reader {
    private static Scanner scan;

    Reader(Scanner scan) {
        Reader.scan = scan;
    }

    public static void init(Scanner scan) {
        Reader.scan = scan;
    }

    public static int readInt(String text) throws ThreeInvalidInput {
        int k = 0;
        try {
            System.out.println(text);
            if (scan.hasNextInt()) {
                k = scan.nextInt();
                scan.nextLine();
            } else throw new invalidInput(" требуется целое число");
        } catch (invalidInput e) {
            scan.nextLine();
            System.out.println(e.toString());
            k = readInt(text);
        }
        invalidInput.setZero();
        return k;
    }

    public static String readString(String text) {
        System.out.println(text);
        return scan.nextLine();
    }

    public static float readFloat(String text) throws ThreeInvalidInput {
        float k = 0;
        try {
            System.out.println(text);
            if (scan.hasNextFloat()) {
                k = scan.nextFloat();
                scan.nextLine();
            } else throw new invalidInput(" требуется ввод десятичной дроби");
        } catch (invalidInput e) {
            scan.nextLine();
            System.out.println(e.toString());
            k = readInt(text);
        }
        invalidInput.setZero();
        return k;
    }

    public static long readLong(String text) throws ThreeInvalidInput {
        long k = 0;
        try {
            System.out.println(text);
            if (scan.hasNextLong()) {
                k = scan.nextLong();
                scan.nextLine();
            } else {
                throw new invalidInput(" требуется целое число");
            }
        } catch (invalidInput e) {
            scan.nextLine();
            System.out.println(e.toString());
            k = readLong(text);
        }
        invalidInput.setZero();
        return k;
    }

    public static PersonType readType(String text) throws ThreeInvalidInput {
        PersonType type = null;
        try {
            System.out.println(text);
            type = PersonType.valueOf((scan.nextInt()));
            scan.nextLine();
        } catch (invalidInput e) {
            System.out.println(e.toString());
            type = readType(text);
        }
        invalidInput.setZero();
        return type;
    }
}
