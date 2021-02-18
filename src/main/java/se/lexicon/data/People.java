package se.lexicon.data;

import com.sun.tools.javac.comp.Todo;
import se.lexicon.model.Person;

import java.util.List;

public interface People {
    Person create(Person person);
    List<Person> findAll();
    Person findById(int id);
    List<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);
}
