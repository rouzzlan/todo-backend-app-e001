package com.falcontech.authtodo.service;

import com.falcontech.authtodo.model.ToDo;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
  private final List<ToDo> todos;

  public ToDoService() {
    todos = new ArrayList<>();
    ToDo toDo = new ToDo();
    toDo.setId("387ddff8-e0ad-44e5-a7a9-ffc6d9866669");
    toDo.setTitle("Test");
    toDo.setText("lorem ipsum");
    toDo.setWriterName("John Do");
    todos.add(toDo);
  }

  public ImmutableList<ToDo> getToDos() {
    return ImmutableList.copyOf(todos);
  }

  public void add(ToDo todo) {
    todos.add(todo);
  }
}
