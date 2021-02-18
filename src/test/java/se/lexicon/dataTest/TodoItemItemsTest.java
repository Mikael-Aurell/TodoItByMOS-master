package se.lexicon.dataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.TodoItems_Impl;
import se.lexicon.model.Todo_Item;
import se.lexicon.model.Person;

public class TodoItemItemsTest {/*
    private Todo_Item[] testMissions = new Todo_Item[3];
    private Todo_Item[] testMissions2 = new Todo_Item[3];
    private Todo_Item[] testMissions3 = new Todo_Item[3];
    private Todo_Item testMission1 = new Todo_Item();
    private Todo_Item testMission2 = new Todo_Item();
    private Todo_Item testMission3 = new Todo_Item();
    private Todo_Item testMission4 = new Todo_Item();
    private Person person1 = new Person();
    private Person person2 = new Person();
    private Person person3 = new Person();

    @Before
    public void setupTodo (){
        person1.getPerson_id();
        person1.setFirst_name("Sebastian");
        person1.setLast_name("Bocaciu");

        person2.getPerson_id();
        person2.setFirst_name("Mikael");
        person2.setLast_name("Aurell");

        person3.getPerson_id();
        person3.setFirst_name("Ola");
        person3.setLast_name("Ulvås");

        testMission1.getTodo_id();
        testMission1.setDescription("Catch the Mouse");
        testMission1.setDone(true);
        testMission1.setAssignee_id(person1);

        testMission2.getTodo_id();
        testMission2.setDescription("Buy a new Car");
        testMission2.setDone(false);
        testMission2.setAssignee_id(person2);

        testMission3.getTodo_id();
        testMission3.setDescription("Buy a new Porsche");
        testMission3.setDone(true);
        testMission3.setAssignee_id(person3);

        testMission4.getTodo_id();
        testMission4.setDescription("Buy a new Porsche");
        testMission4.setDone(true);


        testMissions[0] = testMission1;
        testMissions[1] = testMission2;
        testMissions[2] = testMission3;

        testMissions2[0] = testMission1;
        testMissions2[1] = testMission2;
        testMissions2[2] = testMission3;

        testMissions3[0] = testMission1;
        testMissions3[1] = testMission2;
        testMissions3[2] = testMission3;

    }
    @Test
    public void testAddTodo(){
        TodoItems_Impl testTodoItemsImpl = new TodoItems_Impl();
        testTodoItemsImpl.addTodo(testMission1);
        testTodoItemsImpl.addTodo(testMission2);
        Todo_Item[] expectedTestArray = testMissions;
        Todo_Item[] actualTestArray = testTodoItemsImpl.findAllThingsTodo();
        Assert.assertEquals(expectedTestArray[0].getTodo_id(), actualTestArray[0].getTodo_id());
    }
    @Test
    public void testFindAllThingsTodo(){
        TodoItems_Impl testTodoItemsImpl = new TodoItems_Impl();
        testTodoItemsImpl.addTodo(testMission1);
        testTodoItemsImpl.addTodo(testMission2);
        Todo_Item[] expectedTestArray = testMissions;
        Todo_Item[] actualTestArray = testTodoItemsImpl.findAllThingsTodo();
        Assert.assertArrayEquals(expectedTestArray, actualTestArray);
    }
    @Test
    public void testClearTodo(){
        TodoItems_Impl testClear = new TodoItems_Impl();
        testClear.addTodo(testMission1);
        testClear.addTodo(testMission2);
        testClear.clear();
        Assert.assertNull(null,testClear.findAllThingsTodo());
    }


    @Test
    public void testFindByDoneStatusDynamic() {
        TodoItems_Impl testDoneStatusDynamic = new TodoItems_Impl();
        testDoneStatusDynamic.addTodo(testMission1);
        testDoneStatusDynamic.addTodo(testMission2);
        testDoneStatusDynamic.addTodo(testMission3);
        Assert.assertEquals(testMission3.getTodo_id(), testDoneStatusDynamic.findByDoneStatus(true)[1].getTodo_id());
    }

    @Test
    public void testFindByAssigneeWithPersonId(){
        TodoItems_Impl testFindByAssignee = new TodoItems_Impl();
        testFindByAssignee.addTodo(testMission1);
        testFindByAssignee.addTodo(testMission2);
        testFindByAssignee.addTodo(testMission3);
        Assert.assertEquals("Catch the Mouse",testFindByAssignee.findByAssignee(1)[0].getDescription());
        }
    @Test
    public void testFindByAssigneeWithAssignee(){
        TodoItems_Impl testFindByAssignee = new TodoItems_Impl();
        testFindByAssignee.addTodo(testMission1);
        testFindByAssignee.addTodo(testMission2);
        testFindByAssignee.addTodo(testMission3);
        Assert.assertEquals("Buy a new Porsche",testFindByAssignee.findByAssignee2(person3)[0].getDescription());
    }
    @Test
    public void testFindByUnAssignee(){
        TodoItems_Impl testFindByUnAssignee = new TodoItems_Impl();
        testFindByUnAssignee.addTodo(testMission1);
        testFindByUnAssignee.addTodo(testMission2);
        testFindByUnAssignee.addTodo(testMission3);
        testFindByUnAssignee.addTodo(testMission4);
        Assert.assertNull(null, (testFindByUnAssignee.findUnassignedTodoItems()[0].getAssignee_id()));
    }
    @Test
    public void testRemoveTodo() {
        TodoItems_Impl testRemoveTodo = new TodoItems_Impl();  //Index
        testRemoveTodo.addTodo(testMission1); //0 Catch the Mouse
        testRemoveTodo.addTodo(testMission2); //1 Buy a new Car
        testRemoveTodo.addTodo(testMission3); //2 Buy a new Porsche
        System.out.println("testRemovePerson.size() = " + testRemoveTodo.size());
        testRemoveTodo.removeTodo(2);
        System.out.println("testRemovePerson.size() = " + testRemoveTodo.size());

        int expectedLength = 2;
        int actualLength = testRemoveTodo.size();
        Assert.assertEquals(expectedLength, actualLength);

    }*/
}