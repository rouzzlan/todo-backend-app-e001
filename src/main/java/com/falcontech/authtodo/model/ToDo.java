package com.falcontech.authtodo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToDo {
  private String id;
  private String writerName;
  private String title;
  private String text;

  public ToDo(ToDoBase toDoBase) {
    this.title = toDoBase.getTitle();
    this.text = toDoBase.getText();
  }
}
