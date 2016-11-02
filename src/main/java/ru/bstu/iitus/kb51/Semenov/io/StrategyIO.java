package ru.bstu.iitus.kb51.Semenov.io;

import ru.bstu.iitus.kb51.Semenov.persons.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by User on 09.10.2016.
 */
public interface  StrategyIO {
   public void initStrategy(Object io) throws IOException;
}
