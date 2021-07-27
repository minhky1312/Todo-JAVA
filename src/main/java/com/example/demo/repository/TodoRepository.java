package com.example.demo.repository;

import com.example.demo.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoList,Long> {
    @Override
    Optional<TodoList> findById(Long aLong);
}
