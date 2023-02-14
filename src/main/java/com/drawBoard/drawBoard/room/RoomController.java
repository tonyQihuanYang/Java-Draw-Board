package com.drawBoard.drawBoard.room;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "room")
public class RoomController {
  private final RoomService roomService;
  private AtomicInteger roomIdCounter = new AtomicInteger();
  private AtomicInteger roomUserIdCounter = new AtomicInteger();

  @Autowired
  public RoomController(RoomRepository roomRepository, RoomService roomService) {
    roomRepository.deleteAll();
    this.roomService = roomService;
  }

  @GetMapping("{roomId}")
  public Room getRoom(@PathVariable("roomId") Integer roomId) {
    return roomService.getRoom(roomId);
  }

  @PostMapping("create/{username}")
  public Room createRoom(@PathVariable("username") String userName) {
    return roomService.createRoom(roomIdCounter.getAndIncrement(), roomUserIdCounter.getAndIncrement(), userName);
  }

  @PostMapping("join/{roomId}/{username}")
  public Room joinRoom(@PathVariable("roomId") Integer roomId, @PathVariable("username") String userName) {
    return roomService.joinRoom(roomId, roomUserIdCounter.getAndIncrement(), userName);
  }

  @PostMapping("left/{roomId}/{userId}")
  public Room leftRoom(@PathVariable("roomId") Integer roomId, @PathVariable("userId") Integer userId) {
    return roomService.leftRoom(roomId, userId);
  }
}
