package com.falcontech.authtodo.model;

import com.falcontech.authtodo.security.JwtUserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToDo {
  private String uid;
  private String writerName;
  private String email;
  private String title;
  private String text;

  public ToDo(ToDoBase toDoBase, JwtUserInfo jwtUserInfo) {
    this.title = toDoBase.getTitle();
    this.text = toDoBase.getText();
    this.uid = jwtUserInfo.getUid();
    this.writerName = jwtUserInfo.getName();
    this.email = jwtUserInfo.getEmail();
  }
}
