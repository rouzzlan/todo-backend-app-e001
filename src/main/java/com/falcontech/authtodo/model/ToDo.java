package com.falcontech.authtodo.model;

import lombok.Data;

@Data
public class ToDo {
  private String id;
  private String writerName;
  private String title;
  private String text;
}
