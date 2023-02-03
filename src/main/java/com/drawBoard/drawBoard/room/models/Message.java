package com.drawBoard.drawBoard.room.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
  private String roomId;
  private String sendBy;
  private String message;
  // private DrawPoint message;
}
