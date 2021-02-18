package se.lexicon.modelTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

public class TodoItemTest {/*
    private Todo_Item testTodoItem1;
    private Todo_Item testTodoItem2;
    @Before
    public void setupTestTodo() {
        //Testing constructor "public Todo_Item(){}"
        testTodoItem1 = new Todo_Item();
        //testTodoItem1.getTODOID();
        testTodoItem1.setDescription("Description1");
        testTodoItem1.setDone(false);
        Person assignee1 = new Person();
        assignee1.setFirst_name("Sebastian");
        assignee1.setLast_name("Bocaciu");
        // assignee1.getPERSONID();
        testTodoItem1.setAssignee_id(assignee1);
        //Testing constructor "public Todo_Item(int TODOID, String description){}"
        testTodoItem2 = new Todo_Item("Description2");
    }
    @Test
    public void testTODOID1() {
        int expectedTODOID1 = 1;
        int actualTODOID1 = testTodoItem1.getTodo_id();
        Assert.assertEquals(expectedTODOID1, actualTODOID1);
    }
    @Test
    public void testTodo1Assignee1(){
        Person personExpectedResult = new Person();
        personExpectedResult.setFirst_name("Sebastian");
        personExpectedResult.setLast_name("Bocaciu");
        Person personActualResult = testTodoItem1.getAssignee_id();
        Assert.assertEquals(personExpectedResult.getFirst_name(), personActualResult.getFirst_name());
        Assert.assertEquals(personExpectedResult.getLast_name(), personActualResult.getLast_name());
    }
    @Test
    public void testTodo2() {
        String expectedTestTodo2 = "Description2";
        String actualTestTodo2 = testTodoItem2.getDescription();
        Assert.assertEquals(expectedTestTodo2, actualTestTodo2);
    }
    @Test
    public void testTODOID2() {
        int expectedTODOID2 = 2;
        int actualTODOID2 = testTodoItem2.getTodo_id();
        Assert.assertEquals(expectedTODOID2, actualTODOID2);
    }
    @Test
    public void testBoolean1 () {
        boolean expectedBoolean1 = false;
        boolean actualBoolean1 = testTodoItem1.isDone();
        Assert.assertEquals(expectedBoolean1, actualBoolean1);
    }
    @Test
    public void testAssignee (){
        Person expectedAssignee1 = new Person();
        expectedAssignee1.getPerson_id();
        expectedAssignee1.setFirst_name("Sebastian");
        expectedAssignee1.setLast_name("Bocaciu");
        Person actualAssignee1 = testTodoItem1.getAssignee_id();
        Assert.assertEquals(expectedAssignee1.getFirst_name(), testTodoItem1.getAssignee_id().getFirst_name());
    }*/
}