package se.lexicon.data;


import se.lexicon.dao.db.MySqlConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoItems_Impl implements TodoItems {
    @Override
    public Todo_Item create(Todo_Item todo_item) {
        String query = "insert into todo_item (title,description,deadline,done,assignee_id) values (?,?,?,?,?)";
        try(
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ){
            preparedStatement.setString(1, todo_item.getTitle());
            preparedStatement.setString(2, todo_item.getDescription());
            preparedStatement.setString(3, todo_item.getDeadline().toString());
            preparedStatement.setBoolean(4, todo_item.isDone());
            preparedStatement.setInt(5, todo_item.getAssignee_id());

            int result = preparedStatement.executeUpdate();

            System.out.println((result==1) ? "New Todo_Item added successfully to database" : "Not ok");

            //get generated key from prepared statement
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int idKey = 0;
            while(resultSet.next()){
                idKey = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo_item;
    }

    @Override
    public List<Todo_Item> findAll() {
            String query = "select * from todo_item";
            List<Todo_Item> findAllTodo_Items = new ArrayList<>();
            try{
                Statement statement = MySqlConnection.getConnection().createStatement();

                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    findAllTodo_Items.add(new Todo_Item(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getDate(4).toLocalDate(),
                                    resultSet.getBoolean(5),
                                    resultSet.getInt(6)
                            )
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return findAllTodo_Items;
        }

    @Override
    public Todo_Item findById(int id) {
            String query = "select * from todo_item where todo_id=?";
            Todo_Item findTodoById = new Todo_Item();
            try (
                    PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    findTodoById.setTodo_id(resultSet.getInt(1));
                    findTodoById.setTitle(resultSet.getString(2));
                    findTodoById.setDescription(resultSet.getString(3));
                    findTodoById.setDeadline(resultSet.getDate(4).toLocalDate());
                    findTodoById.setDone(resultSet.getBoolean(5));
                    findTodoById.setAssignee_id(resultSet.getInt(6));
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return findTodoById;
    }

    @Override
    public List<Todo_Item> findByDoneStatus(boolean done) {
        String query = "select * from todo_item where done = ?";
        List<Todo_Item> findTodoByDoneStatus= new ArrayList<>();
        try(
                PreparedStatement preparedStatement=MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setBoolean(1, done);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                findTodoByDoneStatus.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findTodoByDoneStatus;
    }

    @Override
    public List<Todo_Item> findByAssignee(int assignee_id) {
        String query = "select * from todo_item where assignee_id = ?";
        List<Todo_Item> findTodoByAssignee= new ArrayList<>();
        try(
                PreparedStatement preparedStatement=MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, assignee_id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                findTodoByAssignee.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findTodoByAssignee;
    }

    @Override
    public List<Todo_Item> findByAssignee(Person person) {
        String query = "select * from todo_item where assignee_id = ?";
        List<Todo_Item> findTodoByAssignee= new ArrayList<>();
        try(
                PreparedStatement preparedStatement=MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, person.getPerson_id());
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                findTodoByAssignee.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findTodoByAssignee;
    }

    @Override
    public List<Todo_Item> findByUnassignedTodoItems() {
        String query = "select * from todo_item where assignee_id is null";
        List <Todo_Item> findByUnassigned = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                findByUnassigned.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByUnassigned;
    }

    @Override
    public Todo_Item update(Todo_Item todo_item) {
        String query = "update todo_item set title=?, description=?, deadline=?, done=?, assignee_id=? where todo_id= ?";

        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setString(1, todo_item.getTitle());
            preparedStatement.setString(2, todo_item.getDescription());
            preparedStatement.setString(3,todo_item.getDeadline().toString());
            preparedStatement.setBoolean(4,todo_item.isDone());
            preparedStatement.setInt(5,todo_item.getAssignee_id());
            preparedStatement.setInt(6, todo_item.getTodo_id());


            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Todo item updated" : "Todo item not updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo_item;
    }


    @Override
    public boolean deleteById(int todo_id) {
        String query = "delete from todo_item where todo_id = ?";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1,todo_id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Todo_item deleted successfully from the list" : "Todo_item not deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }





    /*
    private static Todo_Item[] todoItemItemsArray = new Todo_Item[0];

    public int size() {
        return todoItemItemsArray.length;
    }

    public Todo_Item[] findAllThingsTodo() {
        return todoItemItemsArray;
    }

    public Todo_Item findByTodoId(int todo_Id) {
        Todo_Item findTodoItem = new Todo_Item();
        int tempTODOID = 0;
        for (int i = 0; i < todoItemItemsArray.length; i++) {
            tempTODOID = todoItemItemsArray[i].getTodo_id();
            if (tempTODOID == todo_Id) {
                findTodoItem = todoItemItemsArray[i];
            }
        }
        return findTodoItem;
    }

    public void addTodo(Todo_Item newThingTodoItem) {
        Todo_Item[] newtodoItemsArray = copyOf(todoItemItemsArray, todoItemItemsArray.length + 1);
        newtodoItemsArray[newtodoItemsArray.length - 1] = newThingTodoItem;
        todoItemItemsArray = newtodoItemsArray;
    }

    public void clear() {
        todoItemItemsArray = null;
    }

    public Todo_Item[] findByDoneStatus(boolean doneStatus) {
        int countDone = 0;
        int countUnDone = 0;
        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].isDone() == true) {
                countDone++;
            } else {
                countUnDone++;
            }
        }

        Todo_Item[] done = new Todo_Item[countDone];
        Todo_Item[] unDone = new Todo_Item[countUnDone];

        int j = 0;
        int k = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].isDone() == true) {
                if (countDone != 0) {
                    done[j] = todoItemItemsArray[i];
                    countDone--;
                    j++;
                }
            } else {
                if (countUnDone != 0) {
                    unDone[k] = todoItemItemsArray[i];
                    countUnDone--;
                    k++;
                }
            }
        }

        if (doneStatus == true) {
            return done;
        } else {
            return unDone;
        }
    }

    public Todo_Item[] findByAssignee(int personId) {
        int counter = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].getAssignee_id().getPerson_id() == personId) {
                counter++;
            }
        }
            Todo_Item[] thingsIShouldDo = new Todo_Item[counter];
            int k = 0;
            for (int j = 0; j < todoItemItemsArray.length; j++) {
                if (todoItemItemsArray[j].getAssignee_id().getPerson_id() == personId) {
                    thingsIShouldDo[k] = todoItemItemsArray[j];
                    k++;
                }
            }
        return thingsIShouldDo;
        }


    public Todo_Item[] findByAssignee2(Person assignee){
        int counter = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].getAssignee_id().getPerson_id() == assignee.getPerson_id()) {
                counter++;
            }
        }
        Todo_Item[] thingsIShouldDo = new Todo_Item[counter];
        int k = 0;
        for (int j = 0; j < todoItemItemsArray.length; j++) {
            if (todoItemItemsArray[j].getAssignee_id().getPerson_id() == assignee.getPerson_id()) {
                thingsIShouldDo[k] = todoItemItemsArray[j];
                k++;
            }
        }
        return thingsIShouldDo;
    }
    public Todo_Item[] findUnassignedTodoItems(){
        int counter = 0;

        for (int i = 0; i < todoItemItemsArray.length; i++) {
            if (todoItemItemsArray[i].getAssignee_id() == null) {
                counter++;
            }
        }
        Todo_Item[] thingsIShouldDo = new Todo_Item[counter];
        int k = 0;
        for (int j = 0; j < todoItemItemsArray.length; j++) {
            if (todoItemItemsArray[j].getAssignee_id() == null) {
                thingsIShouldDo[k] = todoItemItemsArray[j];
                k++;
            }
        }
        return thingsIShouldDo;
    }

    public void removeTodo(int removePerson_Id){
        int index = -1;
        for(int i = 0; i < todoItemItemsArray.length; i++){
            if(todoItemItemsArray[i].getTodo_id() == removePerson_Id){
                index = i;
                break;
            }
        }
        Todo_Item[] newArray = new Todo_Item[todoItemItemsArray.length - 1];

        for(int i = 0, k = 0; i < todoItemItemsArray.length; i++){
            if(i == index){
                continue;
            }
            newArray[k++] = todoItemItemsArray[i];
        }
        todoItemItemsArray = newArray;
    }*/

}
