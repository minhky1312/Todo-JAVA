package com.example.demo.controller;

import com.example.demo.config.Userr;
import com.example.demo.model.TodoList;
import com.example.demo.model.TodoRequest;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DemoRestController {

    @Autowired
    CustomerService customerService;
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/rest")
    public ResponseEntity<?> getPet(String request) {
        System.out.println(request);


        return ResponseEntity.ok(request);
    }

    @GetMapping("/resttodo")
    @PreAuthorize("hasAuthority('ADMIN')")

    public  ResponseEntity<?> getTodo(String request) {
        List<TodoList> todoListsCall = todoRepository.findAll();
        Optional<TodoList> todoList11 =todoRepository.findById(Long.valueOf(3));
        List<TodoList> todoLists1 = new ArrayList<>();
        Long id=Long.valueOf(123);
        SecurityContext securityContextt = SecurityContextHolder.getContext();
        List<Userr> userr = userRepository.findAll();
        for ( Userr userr1 :userr) {
            if (userr1.getUsername().equals(securityContextt.getAuthentication().getPrincipal())) {
                id =  userr1.getId();
            }
        }
//        System.out.println(id);
//        System.out.println("IDUSER: " +todoList11.get().getUserr().getId());
            for (TodoList todoList: todoListsCall) {
                if(todoList.getUserr()!=null) {
                    if(Long.valueOf(todoList.getUserr().getId())==id)
                    {
                        System.out.println("IDUSER: " +todoList11.get().getUserr().getId());
                        todoLists1.add(todoList);
                    }
                }

            }
        System.out.println(todoList11);


        System.out.println(securityContextt.getAuthentication().getPrincipal());
        return  ResponseEntity.ok(todoLists1);
    }

    @GetMapping(value = "/deletetodos")
    public ResponseEntity<?> deleteTodo(@RequestParam int todoid) {

        todoRepository.deleteById(Long.valueOf(todoid));
        return  ResponseEntity.ok().build();
    }

    @PostMapping(value = "/todos")
    public ResponseEntity<?> addTodo(@Valid @RequestBody TodoRequest todoRequest ) {

        System.out.println(todoRequest);
        TodoList todoList = new TodoList( todoRequest.getTodoString(),todoRequest.getHighlight(),todoRequest.getUser_id() );

       todoRepository.save(todoList);


        return  ResponseEntity.ok().build();
    }

    @GetMapping(value = "/edittodo")
    public ResponseEntity<?> editTodo(@RequestParam("id") Long id, @RequestParam("todostring") String todoString, @RequestParam("highlight")boolean highlight) {
       TodoList todoList = new TodoList(id,todoString,highlight);
        todoRepository.save(todoList);


        return  ResponseEntity.ok().build();
    }



}


