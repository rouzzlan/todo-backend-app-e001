package com.falcontech.authtodo.controller;

import com.falcontech.authtodo.model.ToDo;
import com.falcontech.authtodo.model.ToDoBase;
import com.falcontech.authtodo.security.JwtUserInfo;
import com.falcontech.authtodo.security.UserIdentifier;
import com.falcontech.authtodo.service.ToDoService;
import com.google.common.collect.ImmutableList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
  private final ToDoService toDoService;
  private final UserIdentifier userIdentifier;

  public ToDoController(ToDoService toDoService, UserIdentifier userIdentifier) {
    this.toDoService = toDoService;
    this.userIdentifier = userIdentifier;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void postTodo(@RequestHeader("Authorization") String authorization, @RequestBody ToDoBase toDoBase) {
    JwtUserInfo jwtUserInfo = userIdentifier.getUserInfo(authorization);
    toDoService.add(new ToDo(toDoBase, jwtUserInfo));
  }

  @GetMapping
  public ImmutableList<ToDo> getAll() {
    return toDoService.getToDos();
  }
}
