package com.jazwa.testy.service;

import com.jazwa.testy.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> findAll();

    Optional<Todo> findOne(Long id);
}
