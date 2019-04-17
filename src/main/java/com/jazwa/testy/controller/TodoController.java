package com.jazwa.testy.controller;

import com.jazwa.testy.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todosView")
    String getTodosView(Model model){
        model.addAttribute("lista",todoService.findAll());

        return "todos";
    }

    @GetMapping("/todo/{id}")
    String getSingleTodo(Model model,@PathVariable("id") Long id){


        model.addAttribute("singleTodo",todoService.findOne(id).orElseThrow(EntityNotFoundException::new));

        return "oneTodo";
    }


}
