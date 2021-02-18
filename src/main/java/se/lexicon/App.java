package se.lexicon;


import se.lexicon.data.People;
import se.lexicon.data.People_Impl;
import se.lexicon.model.Person;

public class App
{
    public static void main( String[] args )
    {
        People dao = new People_Impl();
        Person duck = dao.create(new Person("Donald", "Duck"));
        System.out.println(duck);
    }
}
