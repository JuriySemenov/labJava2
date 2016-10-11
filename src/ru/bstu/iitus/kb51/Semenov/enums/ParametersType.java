package ru.bstu.iitus.kb51.Semenov.enums;


public enum ParametersType {
    NAME("Name",String.class,"Введите имя"),
    AGE("Age",Integer.class,"Введите возраст"),
    RECORD_BOOK("RecordBook",Long.class,"Номер зачетной книжки студента"),
    AVERAGE_MARk("AverageMark",Double.class,"Средний балл"),
    INN("Inn",String.class,"Введите ИНН"),
    JOB("Job",String.class,"Место работы"),
    GROUP("Group",String.class,"Группа"),
    CLASS("Class",Integer.class,"Класс школьника"),
    SUBJECT("Subject",String.class,"Преподаваемый предмет"),
    CERTIFICATE("certificate",String.class,"Номер сертификата преподователя");
    String text;
    String textForConsole;
    Class<?> cl;
     ParametersType(String text, Class<?> cl,String textForConsole){
        this.text=text;
        this.cl = cl;
         this.textForConsole = textForConsole;
    }


   public static ParametersType value(String text) {
        for (ParametersType type : values()) {
            if (type.text.equals(text)) {
                return type;
            }
        }
        return null;
    }
    public String getCl(){
        return cl.getSimpleName();
    }
    public String getConsoleText(){
        return textForConsole;
    }


}
