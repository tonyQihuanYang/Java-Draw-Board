package com.drawBoard.drawBoard.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RoomAlreadyExistsException extends RuntimeException {
  public RoomAlreadyExistsException(String message) {
    super(message);
  }
}
