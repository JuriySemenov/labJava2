package ru.bstu.iitus.kb51.Semenov.enums;

import ru.bstu.iitus.kb51.Semenov.exception.ThreeInvalidInput;
import ru.bstu.iitus.kb51.Semenov.exception.invalidInput;
import ru.bstu.iitus.kb51.Semenov.persons.*;

public enum PersonType {
    StudentType("Студент",1, Student.class),
    TeacherType("Учитель",2, Teacher.class),
    SchoolkidType("Школьник",3, Schoolkid.class),
    DirectorType("Директор",4, Director.class);
    String value;
    int num;
    Class<?>cl;
    PersonType(String str,int number,Class cl){
        value=str;
        num=number;
        this.cl=cl;
    }
    @Override
    public String toString(){
        return value;
    }
    public static PersonType valueOf(int num) throws ThreeInvalidInput, invalidInput {
        for(PersonType type : values()){
            if(type.num==num){
                return type;
            }
        }
        throw new invalidInput(" не верно введен тип Person");
    }


}