package com.jazwa.testy.controller;

import com.jazwa.testy.model.Todo;
import com.jazwa.testy.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Test
    public void findAllValidTest() throws Exception {
        Todo todo1 = new Todo(1L,"Zakupy","chlep");
        Todo todo2 = new Todo(2L,"Remont","kolanko");

        List<Todo> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);

        when(todoService.findAll()).thenReturn(todos);

        mockMvc.perform(get("/todosView"))
                .andExpect(status().isOk())
                .andExpect(view().name("todos"))
                .andExpect(model().attribute("lista",hasSize(2)));
    }

    @Test
    public void getSingleTodoTest() throws Exception {
        Todo todo1 = new Todo(1L,"Zakupy","chleb");
        Todo todo2 = new Todo(2L,"Remont","kolanko");

        List<Todo> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);


        when(todoService.findOne(any())).thenReturn(Optional.of(todo1));

        mockMvc.perform(get("/todo/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("oneTodo"))
                .andExpect(model().attributeExists("singleTodo"))
                .andExpect(model().attribute("singleTodo",todo1));

                //.andExpect(model().attributeExists("singleTodo"));
                //.andExpect(model().attributeDoesNotExist("singleTodo"));
    }
}