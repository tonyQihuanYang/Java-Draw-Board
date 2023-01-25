package com.drawBoard.drawBoard.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "room")
public class RoomRestController {
  private final RoomService roomService;
  @Autowired
  public RoomRestController(RoomService roomService) {
    this.roomService = roomService;
  }
}
