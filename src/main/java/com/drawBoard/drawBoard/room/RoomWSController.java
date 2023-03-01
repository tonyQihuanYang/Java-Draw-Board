package com.drawBoard.drawBoard.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.drawBoard.drawBoard.room.models.Messages.DrawPoint;

@Controller
public class RoomWSController {
  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  Logger logger = LoggerFactory.getLogger(RoomWSController.class);

  @MessageMapping("/draw-room/{roomId}/syncRequest")
  public String receiveSyncRequest(@DestinationVariable String roomId, @Payload String message) {
    simpMessagingTemplate.convertAndSendToUser(roomId, "/syncRequest", message);
    return message;
  }

  @MessageMapping("/draw-room/{roomId}/sync")
  public String receiveSync(@DestinationVariable String roomId, @Payload String message) {
    simpMessagingTemplate.convertAndSendToUser(roomId, "/sync", message);
    return message;
  }

  @MessageMapping("/draw-room/{roomId}/drawUpdate")
  public DrawPoint receiveDrawUpdate(@DestinationVariable String roomId, @Payload DrawPoint message) {
    simpMessagingTemplate.convertAndSendToUser(roomId, "/drawUpdated", message);
    return message;
  }
}
