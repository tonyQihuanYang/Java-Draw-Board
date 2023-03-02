package com.drawBoard.drawBoard.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.drawBoard.drawBoard.room.models.Messages.DrawPoint;
import com.drawBoard.drawBoard.room.models.Messages.RoomSyncMessage;

@Controller
public class RoomWSController {
  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/draw-room/{roomId}/syncRequest")
  public String receiveSyncRequest(@DestinationVariable String roomId, @Payload String message) {
    simpMessagingTemplate.convertAndSendToUser(roomId, "/syncRequest", message);
    return message;
  }

  @MessageMapping("/draw-room/{roomId}/sync")
  public RoomSyncMessage receiveSync(@DestinationVariable String roomId, @Payload RoomSyncMessage message) {
    simpMessagingTemplate.convertAndSendToUser(roomId, "/sync", message);
    return message;
  }

  @MessageMapping("/draw-room/{roomId}/drawUpdate")
  public DrawPoint receiveDrawUpdate(@DestinationVariable String roomId, @Payload DrawPoint message) {
    simpMessagingTemplate.convertAndSendToUser(roomId, "/drawUpdated", message);
    return message;
  }
}
