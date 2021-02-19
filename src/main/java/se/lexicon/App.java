package se.lexicon;


import se.lexicon.data.People;
import se.lexicon.data.People_Impl;
import se.lexicon.data.TodoItems;
import se.lexicon.data.TodoItems_Impl;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.time.LocalDate;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        People dao = new People_Impl();
        TodoItems dao2 = new TodoItems_Impl();
        //Create
        Person ake = dao.create(new Person("Åke","Åkesson"));
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
        //Person personToUpdate = dao.update(new Person(1,"Åke","Åkesson"));
        //List<Person> persons = dao.findAll();
        //persons.forEach(System.out::println);

        //Delete
        //boolean deletePerson = dao.deleteById(7);
        //System.out.println(deletePerson);
        //List<Person> persons = dao.findAll();
        //persons.forEach(System.out::println);
        //------------------------------------------------------------
        //TODO_ITEM TESTS

        //Create
        //Todo_Item addedTodo_item = dao2.create(new Todo_Item("Buy food","Beer, fruit, candy.", LocalDate.parse("2021-02-19"),true,8));
        //System.out.println(addedTodo_item);

        //ListAllTodoItems
        //List<Todo_Item> todo_items = dao2.findAll();
        //todo_items.forEach(System.out::println);

        //FindById
        Todo_Item findById = dao2.findById(4);
        System.out.println(findById);
        }
    }

