package com.falcontech.authtodo.controller;

import com.falcontech.authtodo.model.ToDo;
import com.falcontech.authtodo.service.ToDoService;
import com.google.common.collect.ImmutableList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
  private final ToDoService toDoService;

  public ToDoController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void postTodo(@RequestBody ToDo todo) {
    toDoService.add(todo);
  }

  @GetMapping
  public ImmutableList<ToDo> getAll() {
    return toDoService.getToDos();
  }
}
