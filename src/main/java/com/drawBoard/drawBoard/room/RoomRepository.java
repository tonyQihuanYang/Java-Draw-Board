package com.drawBoard.drawBoard.room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
  List<Room> findAll();
}
