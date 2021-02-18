package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.util.List;

public interface TodoItems {
Todo_Item create(Todo_Item todo_item);
List<Todo_Item> findAll();
Todo_Item findById(int id);
List<Todo_Item> findByDoneStatus(boolean done);
List<Todo_Item> findByAssignee(int assignee);
List<Todo_Item> findByAssignee(Person person);
List<Todo_Item> findByUnassignedTodoItems();
Todo_Item update(Todo_Item todo_item);
boolean deleteById(int id);
}
