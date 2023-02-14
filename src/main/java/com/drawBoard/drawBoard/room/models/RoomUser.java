package com.drawBoard.drawBoard.room.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomUser {
  private Integer id;
  private String name;
  private UserType userType;

  public RoomUser(Integer id, String name, UserType userType) {
    this.id = id;
    this.name = name;
    this.userType = userType;
  }
}
