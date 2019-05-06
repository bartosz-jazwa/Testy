package com.jazwa.testy.service;

import com.jazwa.testy.model.Todo;
import com.jazwa.testy.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class    TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findOne(Long id)  {
        return todoRepository.findById(id);
    }


}
