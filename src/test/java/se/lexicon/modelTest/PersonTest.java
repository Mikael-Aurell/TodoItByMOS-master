package se.lexicon.modelTest;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Person;
import static org.junit.Assert.*;
public class PersonTest {
    private Person testPerson1;
    private Person testPerson2;
    @Before
    public void setupTest() {
        // Testperson 1
        testPerson1 = new Person();
        //testPerson1.getPERSONID();
        testPerson1.setFirst_name("Sebastian");
        testPerson1.setLast_name("Bocaciu");
        // Testperson 2 PERSONID only
        testPerson2 = new Person();
        //testPerson2.getPERSONID();
    }
    @Test
    public void testPERSONID() {
        int expectedPERSONID = 1;
        int actualPERSONID = testPerson1.getPerson_id();
        assertEquals(expectedPERSONID, actualPERSONID);
    }
    @Test
    public void testFirstName() {
        String expectedTestPerson1 = "Sebastian";
        String actualTestPerson1 = testPerson1.getFirst_name();
        assertEquals(expectedTestPerson1, actualTestPerson1);
    }
    @Test
    public void testLastName() {
        String expectedTestPerson1 = "Bocaciu";
        String actualTestPerson1 = testPerson1.getLast_name();
        assertEquals(expectedTestPerson1, actualTestPerson1);
    }
    //Testing PERSONID sequenser
    @Test
    public void testPERSONID2() {
        int expectedPERSONID2 = 2;
        int actualPERSONID2 = testPerson2.getPerson_id();
        assertEquals(expectedPERSONID2, actualPERSONID2);
    }
}