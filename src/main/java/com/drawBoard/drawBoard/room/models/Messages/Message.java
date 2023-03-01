package com.drawBoard.drawBoard.room.models.Messages;

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
public class Message<T> {
  private String roomId;
  private String sendBy;
  protected T message;
}
