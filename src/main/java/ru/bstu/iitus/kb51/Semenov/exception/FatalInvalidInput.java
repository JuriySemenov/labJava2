package ru.bstu.iitus.kb51.Semenov.exception;


public class FatalInvalidInput extends Exception {
    String message="";
    public FatalInvalidInput(String s) {
        super(s);
        message=s;
    }
    public FatalInvalidInput(){}
    @Override
    public String toString(){
        return "Не корректный ввод данных 3 раза. Завершение работы программы.";
    }
}
