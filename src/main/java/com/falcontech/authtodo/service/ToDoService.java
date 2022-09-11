package com.falcontech.authtodo.service;

import com.falcontech.authtodo.model.ToDo;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
  private List<ToDo> todos = new ArrayList<>();

  public ImmutableList<ToDo> getToDos() {
    return ImmutableList.copyOf(todos);
  }

  public void add(ToDo todo) {
    todos.add(todo);
  }
}
