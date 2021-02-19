package se.lexicon.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Todo_Item {
    private int todo_id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean done;
    private int assignee_id;

    public Todo_Item() {
    }

    public Todo_Item(int todo_id, String title, String description, LocalDate date, boolean done, int assignee_id) {
        this.todo_id = todo_id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public Todo_Item(String title, String description, LocalDate date, boolean done, int assignee_id) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo_Item todo_item = (Todo_Item) o;
        return todo_id == todo_item.todo_id && done == todo_item.done && assignee_id == todo_item.assignee_id && Objects.equals(title, todo_item.title) && Objects.equals(description, todo_item.description) && Objects.equals(date, todo_item.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_id, title, description, date, done, assignee_id);
    }

    @Override
    public String toString() {
        return "Todo_Item{" +
                "todo_id=" + todo_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", done=" + done +
                ", assignee_id=" + assignee_id +
                '}';
    }
}