package com.drawBoard.drawBoard.room;

import java.util.List;

import com.drawBoard.drawBoard.user.User;

public class Room {
  private Long id;
  private List<User> users;

 public Room(Long id) {
  this.id = id;
 }

 public List<User> getUsers() {
  return this.users;
 }

 public void addUser(User user) {
  this.users.add(user);
 }
}
