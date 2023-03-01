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
public class DrawPoint {
  private CanvasCoordinates prevCoord;
  private CanvasCoordinates newCoord;
  private String penColor;
  private Number penWidth;
}
