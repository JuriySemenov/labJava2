package ru.bstu.iitus.kb51.Semenov.enums;

import ru.bstu.iitus.kb51.Semenov.exception.FatalInvalidInput;
import ru.bstu.iitus.kb51.Semenov.exception.invalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.*;

public enum PersonType {
    StudentType("Студент",1, Student.class,"Студент"),
    TeacherType("Учитель",2, Teacher.class,"Преподаватель"),
    SchoolkidType("Школьник",3, Schoolkid.class,"Школьник"),
    DirectorType("Директор",4, Director.class,"Директор");
    String value;
    int num;
    String name;
    Class<?>cl;
    PersonType(String str, int number, Class cl,String name){
        value=str;
        num=number;
        this.cl=cl;
        this.name=name;
    }
    @Override
    public String toString(){
        return value;
    }

    public static PersonType getType(String name){
        for(PersonType type : values()){
            if(type.name.equals(name)){
                return type;
            }
        }
        return null;
    }

    public static PersonType valueOf(int num) throws FatalInvalidInput, invalidInput {
        for(PersonType type : values()){
            if(type.num==num){
                return type;
            }
        }
        throw new invalidInput(" не верно введен тип Person");
    }
    public Object getInstance()  {
        try {
            return  cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}