package ru.bstu.iitus.kb51.Semenov.exception;


public class ThreeInvalidInput extends Exception {
    String message="";
    public ThreeInvalidInput(String s) {
        super(s);
        message=s;
    }
    public ThreeInvalidInput(){}
    @Override
    public String toString(){
        return "Не корректный ввод данных 3 раза. Завершение работы программы.";
    }
}
