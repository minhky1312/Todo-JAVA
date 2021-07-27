package com.example.demo.model;

import com.example.demo.config.Userr;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String todoString;

    @NotNull
    private Boolean highlight;

    private String userName;

    public  TodoList() {}
    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", todoString='" + todoString + '\'' +
                ", highlight=" + highlight +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodoString() {
        return todoString;
    }

    public void setTodoString(String todoString) {
        this.todoString = todoString;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public TodoList(Long id, String todoString, boolean highlight) {
        this.id = id;
        this.todoString = todoString;
        this.highlight = highlight;
    }

    @JsonIgnore
    @ManyToOne
    private Userr userr;

    public TodoList (String todoString,boolean highlight)
    {
        this.todoString=todoString;
        this.highlight=highlight;
    }



    public TodoList (String todoString,boolean highlight, Long user_id)
    {
        this.todoString=todoString;
        this.highlight=highlight;
        this.userr = new Userr(user_id);
    }



    public Userr getUserr() {
        return userr;
    }



    public void setUserr(Userr userr) {
        this.userr = userr;
    }
}
