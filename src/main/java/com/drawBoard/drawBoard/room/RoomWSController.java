package com.drawBoard.drawBoard.room;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.drawBoard.drawBoard.room.models.Message;

@Controller
public class RoomWSController {
  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  // Logger logger = LoggerFactory.getLogger(RoomWSController.class);

  @MessageMapping("/draw-room")
  public Message receiveDrawUpdate(@Payload Message message) {
    simpMessagingTemplate.convertAndSendToUser(message.getRoomId(), "/update", message);
    return message;
  }
}
