package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.enums.ParametersType;
import ru.bstu.iitus.kb51.Semenov.enums.PersonType;
import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by User on 10.10.2016.
 */
public class FileReaderHTML implements StrategyReader {
    private File file;
    private BufferedReader reader;
    private ArrayList<Pattern> patterns;
    private EnumMap<ParametersType,String> parametrs;
    private boolean flag=false;
    void initReg() {
        patterns = new ArrayList<>();
        String template = "<type>(.*)</type>";
        patterns.add(Pattern.compile(template));
        template = "<include name=\"(.*)\">";
        patterns.add(Pattern.compile(template));
        template = "<property name=\"arg\">(.*)";
        for (ParametersType p : ParametersType.values()) {
            if(!p.equals(ParametersType.TYPE)&&!p.equals(ParametersType.NAME)) {
                String patern = template.replace("arg", p.toString());
                patterns.add(Pattern.compile(patern));
            }
        }
    }

    void setParametrs(String s){
        if(parametrs == null){
            parametrs=new EnumMap<>(ParametersType.class);
        }
        Matcher matcher;
        int count = 0;
        String ss[] = s.split("</property");
        for(String some:ss) {
            count=0;
            for (Pattern p : patterns) {
                matcher = p.matcher(some);
                if (matcher.find()) {
                    parametrs.put(ParametersType.values()[count], matcher.group(1));
                }
                count++;
            }
        }
        EndPerson(s);
    }
    void EndPerson(String s){
        if(s.contains("</resource>")){
            flag=true;
        }
    }
    public FileReaderHTML(String path) {
        initStrategy(path);
    }


    @Override
    public Object readParams(ParametersType type) throws FatalInvalidInput {
        if(parametrs.get(type)!=null) {
            switch (type.getCl()) {
                case ("String"):
                    return parametrs.get(type);
                case ("Double"):
                    return Double.parseDouble(parametrs.get(type));
                case ("Integer"):
                    return Integer.parseInt(parametrs.get(type));
                case ("Long"):
                    return Long.parseLong(parametrs.get(type));
                case ("PersonType"):
                    return PersonType.getType(parametrs.get(type));
            }
        }
        else return null;
       throw new FatalInvalidInput("FileReaderHTML.readParams");
    }

private Person getPerson()throws FatalInvalidInput{
    PersonType p = (PersonType) readParams(ParametersType.TYPE);
    return (Person)p.getInstance();
}
    @Override
    public LinkedList<Person> readPersons() throws FatalInvalidInput {
        LinkedList<Person> persons = new LinkedList<>();
        initReg();
        String s;
        try {
            while ((s = reader.readLine()) != null) {
                setParametrs(s);
                if (flag) {
                    Person p = getPerson();
                    p.init();
                    persons.add(p);
                    parametrs.clear();
                    flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public void initStrategy(Object io) {
        try {
            file = new File((String) io);
            reader = new BufferedReader(new java.io.FileReader(file.getAbsoluteFile()));
        } catch (IOException e) {
            System.out.println("Не найден файл...");
        }
    }
}
