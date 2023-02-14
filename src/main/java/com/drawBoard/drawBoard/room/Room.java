package com.drawBoard.drawBoard.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.redis.core.RedisHash;

import com.drawBoard.drawBoard.room.models.RoomUser;

@RedisHash("Room")
public class Room implements Serializable {
  private Integer id;
  private List<RoomUser> users;

  public Room(Integer id) {
    this.id = id;
    this.users = new ArrayList<RoomUser>();
  }

  public void addUser(RoomUser user) {
    this.users.add(user);
  }

  public void removeUser(Integer userId) {
    this.users = this.users.stream().filter(user -> !user.getId().equals(userId)).collect(Collectors.toList());
  }

  public Integer getId() {
    return id;
  }

  public List<RoomUser> getUsers() {
    return this.users;
  }
}
