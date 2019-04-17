package com.jazwa.testy.controller;

import com.jazwa.testy.model.Todo;
import com.jazwa.testy.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {

    @Autowired
    TodoService todoService;

    @GetMapping("todos")
    ResponseEntity<List<Todo>> getAll(){
        return ResponseEntity.ok().body(todoService.findAll());
    }

}
