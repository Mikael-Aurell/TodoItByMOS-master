package se.lexicon.data;
import se.lexicon.dao.db.MySqlConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class People_Impl implements People{
    @Override
    public Person create(Person person) {
        String query = "insert into person (first_name,last_name) values (?,?)";
        try(
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ){
            preparedStatement.setString(1, person.getFirst_name());
            preparedStatement.setString(2, person.getLast_name());

            int result = preparedStatement.executeUpdate();

            System.out.println((result==1) ? "New City added successfully to database" : "Not ok");

            //get generated key from prepared statement
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int idKey = 0;
            while(resultSet.next()){
                idKey = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public List<Person> findByName(String name) {

    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
    /*private static Person[] peopleArray = new Person[0];
    public int size() {
        return peopleArray.length;
    }
    public Person[] findAll() {
        return peopleArray;
    }
    public Person findById(int person_Id) {
        Person findPerson = new Person();
        int tempPERSONID = 0;
        for (int i = 0; i < peopleArray.length; i++) {
            tempPERSONID = peopleArray[i].getPerson_id();
            if (tempPERSONID == person_Id) {
                findPerson = peopleArray[i];
            }
        }
        return findPerson;
    }
    public void addPerson(Person newPerson) {
        Person[] newPeopleArray = Arrays.copyOf(peopleArray, peopleArray.length + 1);
        newPeopleArray[newPeopleArray.length - 1] = newPerson;
        peopleArray = newPeopleArray;
    }
    public void remove(int removePerson_Id){
        int index = -1;
        for(int i = 0; i < peopleArray.length; i++){
            if(peopleArray[i].getPerson_id() == removePerson_Id){
                index = i;
                break;
            }
        }
        Person[] newArray = new Person[peopleArray.length - 1];

        for(int i = 0, k = 0; i < peopleArray.length; i++){
            if(i == index){
                continue;
            }
            newArray[k++] = peopleArray[i];
        }
        peopleArray = newArray;
    }


    public void clear (){
        peopleArray = null;
    }*/
}