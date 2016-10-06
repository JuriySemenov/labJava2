package ru.bstu.iitus.kb51.Semenov.exception;

public class invalidInput extends Exception{
    static int count = 0;
    String message="";
    public invalidInput(String s) throws ThreeInvalidInput {
        super(s);
        count++;
        if (count < 3) {
            message=s;
        }
        else
        throw new ThreeInvalidInput();

    }
    static public void setZero(){
        count=0;
    }
    @Override
    public String toString(){
        return "Не коректный ввод данных"+message;
    }

}
