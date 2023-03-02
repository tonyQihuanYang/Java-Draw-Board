package com.drawBoard.drawBoard.room.models.Messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomSyncMessage {
  private String dataUrl;
  private Number width;
  private Number height;
}
