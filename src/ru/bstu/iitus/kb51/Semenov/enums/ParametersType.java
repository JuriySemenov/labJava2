package ru.bstu.iitus.kb51.Semenov.enums;


public enum ParametersType {
    TYPE("type",PersonType.class,"Введите тип"),
    NAME("name", String.class, "Введите имя"),
    AGE("age", Integer.class, "Введите возраст"),
    RECORD_BOOK("bookNumber", Long.class, "Номер зачетной книжки студента"),
    AVERAGE_MARk("averageMark", Double.class, "Средний балл"),
    INN("inn", String.class, "Введите ИНН"),
    JOB("job", String.class, "Место работы"),
    GROUP("group", String.class, "Группа"),
    CLASS("class", Integer.class, "Класс школьника"),
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

