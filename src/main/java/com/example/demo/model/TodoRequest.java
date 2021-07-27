package com.example.demo.model;

public class TodoRequest {
    private String todoString;
    private Boolean highlight;

    public String getTodoString() {
        return todoString;
    }

    public void setTodoString(String todoString) {
        this.todoString = todoString;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    private Long user_id;

    @Override
    public String toString() {
        return "TodoRequest{" +
                "todoString='" + todoString + '\'' +
                ", highlight=" + highlight +
                ", user_id=" + user_id +
                '}';
    }
}

