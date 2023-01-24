package com.drawBoard.drawBoard.account;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

  @Bean
  CommandLineRunner commandLineRunner(AccountRepository repository) {
    return arg -> {
      Account testUser = new Account("test", "123456789");
      repository.saveAll(List.of(testUser));
    };
  }
}
