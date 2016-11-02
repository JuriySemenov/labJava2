package ru.bstu.iitus.kb51.Semenov.enums;


public enum ParametersType {
    TYPE("type",PersonType.class,"Тип личности"),
    NAME("name", String.class, "Имя"),
    AGE("age", Integer.class, "Возраст"),
    RECORD_BOOK("bookNumber", Long.class, "Номер зачетной книжки студента"),
    AVERAGE_MARk("averageMark", Double.class, "Средний балл"),
    INN("inn", String.class, "ИНН"),
    JOB("job", String.class, "Место работы"),
    GROUP("group", String.class, "Группа"),
    CLASS("schoolClass", String.class, "Класс школьника"),
    SUBJECT("subject", String.class, "Преподаваемый предмет"),
    CERTIFICATE("certificat", String.class, "Номер сертификата преподователя");
    String text;
    String textForConsole;
    Class<?> cl;

    ParametersType(String text, Class<?> cl, String textForConsole) {
        this.text = text;
        this.cl = cl;
        this.textForConsole = textForConsole;
    }

    @Override
    public String toString() {
        return text;
    }

    public static ParametersType value(String text) {
        for (ParametersType type : values()) {
            if (type.text.equals(text)) {
                return type;
            }
        }
        return null;
    }

    public String getCl() {
        return cl.getSimpleName();
    }

    public String getConsoleText() {
        return textForConsole;
    }
}

