package com.drawBoard.drawBoard.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RoomWSController {
  @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/draw-room")
  @SendTo("/draw-room/")
  public Message receiveDrawUpdate(@Payload Message message) {
    simpMessagingTemplate.convertAndSendToUser(message.getRoomId(),"/update", message);
    return message;
  }
}
