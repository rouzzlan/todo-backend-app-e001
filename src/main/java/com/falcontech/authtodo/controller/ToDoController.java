package com.falcontech.authtodo.controller;

import com.falcontech.authtodo.model.ToDo;
import com.falcontech.authtodo.model.ToDoBase;
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
  public void postTodo(@RequestHeader("Authorization") String authorization, @RequestBody ToDoBase toDoBase) {
    toDoService.add(new ToDo(toDoBase));
  }

  @GetMapping
  public ImmutableList<ToDo> getAll() {
    return toDoService.getToDos();
  }
}
