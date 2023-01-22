package com.drawBoard.drawBoard.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService= accountService;
  }

  @GetMapping
  public void getUser() {
    accountService.createAccount();
  }
}
