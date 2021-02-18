package se.lexicon.data;
import se.lexicon.dao.db.MySqlConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String query = "select person_id, first_name, last_name from person";
        List<Person> findAllPersons = new ArrayList<>();
        try{
            Statement statement = MySqlConnection.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                findAllPersons.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                                )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findAllPersons;
    }

    @Override
    public Person findById(int id) {
        String query = "select * from person where person_id=?";
        Person findPersonById = new Person();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                findPersonById.setPerson_id(resultSet.getInt(1));
                findPersonById.setFirst_name(resultSet.getString(2));
                findPersonById.setLast_name(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findPersonById;
    }

    @Override
    public List<Person> findByName(String name) {
        String query = "select * from person where first_name=?";
        List<Person> findPersons = new ArrayList<>();
        try (
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                findPersons.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findPersons;
    }

        @Override
    public Person update(Person person) {
            String query = "update person set first_name=?, last_name=? where person_id=? ";
            try(
                    PreparedStatement preparedStatement =
                            MySqlConnection.getConnection().prepareStatement(query);
            ){
                preparedStatement.setString(1, person.getFirst_name());
                preparedStatement.setString(2, person.getLast_name());
                preparedStatement.setInt(3, person.getPerson_id());

                int result = preparedStatement.executeUpdate();

                System.out.println((result==1) ? "New City added successfully to database" : "Not ok");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return person;
    }

    @Override
    public boolean deleteById(int id) {
        int result=0;
        String query= "delete from person where person_id=?";

        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
                ){
            preparedStatement.setInt(1,id);

            result = preparedStatement.executeUpdate();
            System.out.println((result==1) ? "New City deleted successfully to database" : "Not ok");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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