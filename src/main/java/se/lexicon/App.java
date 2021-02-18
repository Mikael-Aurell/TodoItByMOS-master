package se.lexicon;


import se.lexicon.data.People;
import se.lexicon.data.People_Impl;
import se.lexicon.model.Person;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        People dao = new People_Impl();

        //Create
        //Person trump = dao.create(new Person("Donald", "Trump"));
        //System.out.println(duck);

        //FindByName
        //List<Person> personList = dao.findByName("Donald");
        //personList.forEach(System.out::println);

        //FindAll
        //List<Person> persons = dao.findAll();
        //persons.forEach(System.out::println);

        //FindById
        //Person person = dao.findById(2);
        //System.out.println(person);

        //Update
        //Person personToUpdate = dao.update(new Person(1,"Donaldz","Duck"));
        //List<Person> persons = dao.findAll();
        //persons.forEach(System.out::println);

        //Delete
        //boolean deletePerson = dao.deleteById(7);
        //System.out.println(deletePerson);
        List<Person> persons = dao.findAll();
        persons.forEach(System.out::println);
        }
    }

