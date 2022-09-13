package com.falcontech.authtodo.controller;

import com.falcontech.authtodo.model.ToDo;
import com.falcontech.authtodo.service.ToDoService;
import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/public")
public class PublicController {
  private final ToDoService toDoService;

  public PublicController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }
  @GetMapping
  public ImmutableList<ToDo> getAll() {
    return toDoService.getToDos();
  }
}
