package com.drawBoard.drawBoard.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawBoard.drawBoard.models.exceptions.RoomAlreadyExistsException;
import com.drawBoard.drawBoard.models.exceptions.RoomNotFoundException;
import com.drawBoard.drawBoard.room.models.RoomUser;
import com.drawBoard.drawBoard.room.models.UserType;

import java.util.Optional;

@Service
public class RoomService {
  private final RoomRepository roomRepository;

  @Autowired
  private RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public Room createRoom(String roomId, Integer userId, String userName) throws RoomAlreadyExistsException {
    if (roomRepository.findById(roomId).isPresent()) {
      throw new RoomAlreadyExistsException("Room Existed");
    }
    RoomUser creator = new RoomUser(userId, userName, UserType.OWNER);
    Room newRoom = new Room(roomId);
    newRoom.addUser(creator);

    roomRepository.save(newRoom);
    return newRoom;
  }

  public Room getRoom(String roomId) throws RoomNotFoundException {
    return roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
  }

  public Room joinRoom(String roomId, Integer userId, String userName) throws RoomNotFoundException {
    Room roomFound = getRoom(roomId);
    RoomUser player = new RoomUser(userId, userName, UserType.PLAYER);
    roomFound.addUser(player);
    roomRepository.save(roomFound);
    return roomFound;
  }

  public Room leftRoom(String roomId, Integer userId) throws RoomNotFoundException {
    Room room = getRoom(roomId);
    Optional<RoomUser> userToRemove = room.getUsers().stream().filter(user -> user.getId().equals(userId)).findFirst();

    if (userToRemove.isEmpty()) {
      return room;
    }
    boolean isOwner = userToRemove.get().getUserType().equals(UserType.OWNER);
    if (isOwner) {
      roomRepository.deleteById(roomId);
      return null;
    } else {
      room.removeUser(userId);
      roomRepository.save(room);
      return room;
    }
  }
}
