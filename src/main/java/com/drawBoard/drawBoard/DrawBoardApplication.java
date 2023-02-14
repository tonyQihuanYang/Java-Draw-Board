package com.drawBoard.drawBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DrawBoardApplication {

  static Logger logger = LoggerFactory.getLogger(DrawBoardApplication.class);
  public static void main(String[] args) {
		SpringApplication.run(DrawBoardApplication.class, args);
	}

  @GetMapping("/healthcheck")
  public String healthCheck() {
    return "Ok!";
  }
}
