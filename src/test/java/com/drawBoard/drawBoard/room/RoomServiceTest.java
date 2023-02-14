package com.drawBoard.drawBoard.room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.drawBoard.drawBoard.room.models.UserType;
import com.drawBoard.drawBoard.models.exceptions.RoomAlreadyExistsException;
import com.drawBoard.drawBoard.models.exceptions.RoomNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoomServiceTest {
  @Autowired
  private RoomRepository roomRepository;

  @Autowired
  private RoomService roomService;

  @BeforeEach
  public void setup() {
    roomRepository.deleteAll();
  }

  @Test
  void shouldCreateRoomSuccess() {
    Integer roomIdStub = 1;
    Integer roomUserIdStub = 1;
    String roomUserNameStub = "UserName1";

    Room newRoom = roomService.createRoom(roomIdStub, roomUserIdStub, roomUserNameStub);
    assertThat(newRoom.getId()).isEqualTo(roomIdStub);
    assertThat(newRoom.getUsers().get(0).getId()).isEqualTo(roomUserIdStub);
    assertThat(newRoom.getUsers().get(0).getName()).isEqualTo(roomUserNameStub);
    assertThat(newRoom.getUsers().get(0).getUserType()).isEqualTo(UserType.OWNER);
  }

  void shouldThrowWhenCreateDuplicatedRoom() {
    Integer roomIdStub = 1;
    Integer roomUserIdStub = 1;
    String roomUserNameStub = "UserName1";

    roomService.createRoom(roomIdStub, roomUserIdStub, roomUserNameStub);

    RoomAlreadyExistsException thrown = assertThrows(RoomAlreadyExistsException.class,
        () -> roomService.createRoom(roomIdStub, roomUserIdStub, roomUserNameStub));
    assertTrue(thrown.getMessage().contentEquals("Room Existed"));
  }

  @Test
  void shouldFoundRoomSuccess() {
    Integer roomIdStub = 2;
    Integer roomUserIdStub = 2;
    String roomUserNameStub = "UserName2";
    roomService.createRoom(roomIdStub, roomUserIdStub, roomUserNameStub);

    Room room = roomService.getRoom(roomIdStub);
    assertThat(room.getId()).isEqualTo(roomIdStub);
    assertThat(room.getUsers().get(0).getName()).isEqualTo(roomUserNameStub);
    assertThat(room.getUsers().get(0).getUserType()).isEqualTo(UserType.OWNER);
  }

  @Test
  void shouldThrowWhenNoRoomFound() {
    Integer roomIdStub = 2;
    RoomNotFoundException thrown = assertThrows(RoomNotFoundException.class,
        () -> roomService.getRoom(roomIdStub));
    assertTrue(thrown.getClass().equals(RoomNotFoundException.class));
  }

  @Test
  void shouldAbleJoinRoomSuccess() {
    Integer roomIdStub = 3;
    Integer roomOwnerIdStub = 3;
    String roomOnwerNameStub = "Owner3";
    Integer newPlayerIdStub = 4;
    String newPlayerNameStub = "Player4";
    roomService.createRoom(roomIdStub, roomOwnerIdStub, roomOnwerNameStub);
    roomService.joinRoom(roomIdStub, newPlayerIdStub, newPlayerNameStub);

    Room room = roomService.getRoom(roomIdStub);
    assertThat(room.getId()).isEqualTo(roomIdStub);
    assertThat(room.getUsers().size()).isEqualTo(2);
    assertThat(room.getUsers().get(0).getName()).isEqualTo(roomOnwerNameStub);
    assertThat(room.getUsers().get(0).getUserType()).isEqualTo(UserType.OWNER);
    assertThat(room.getUsers().get(1).getName()).isEqualTo(newPlayerNameStub);
    assertThat(room.getUsers().get(1).getUserType()).isEqualTo(UserType.PLAYER);
  }

  @Test
  void shouldAbleLeftRoomSuccess() {
    Integer roomIdStub = 3;
    Integer roomOwnerIdStub = 3;
    String roomOnwerNameStub = "Owner3";
    Integer newPlayerIdStub = 4;
    String newPlayerNameStub = "Player4";
    roomService.createRoom(roomIdStub, roomOwnerIdStub, roomOnwerNameStub);
    roomService.joinRoom(roomIdStub, newPlayerIdStub, newPlayerNameStub);
    roomService.leftRoom(roomIdStub, newPlayerIdStub);

    Room room = roomService.getRoom(roomIdStub);
    assertThat(room.getId()).isEqualTo(roomIdStub);
    assertThat(room.getUsers().size()).isEqualTo(1);
    assertThat(room.getUsers().get(0).getName()).isEqualTo(roomOnwerNameStub);
    assertThat(room.getUsers().get(0).getUserType()).isEqualTo(UserType.OWNER);
  }

  @Test
  void shouldCleanRoomWhenOwenerLeftRoom() {
    Integer roomIdStub = 3;
    Integer roomOwnerIdStub = 3;
    String roomOnwerNameStub = "Owner3";
    Integer newPlayerIdStub = 4;
    String newPlayerNameStub = "Player4";
    roomService.createRoom(roomIdStub, roomOwnerIdStub, roomOnwerNameStub);
    roomService.joinRoom(roomIdStub, newPlayerIdStub, newPlayerNameStub);
    roomService.leftRoom(roomIdStub, newPlayerIdStub);

    Room room = roomService.getRoom(roomIdStub);
    assertThat(room.getUsers().size()).isEqualTo(1);
    roomService.leftRoom(roomIdStub, roomOwnerIdStub);

    RoomNotFoundException thrown = assertThrows(RoomNotFoundException.class,
        () -> roomService.getRoom(roomIdStub));
    assertTrue(thrown.getClass().equals(RoomNotFoundException.class));
  }
}
