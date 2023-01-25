package com.drawBoard.drawBoard.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/signin")
  public String signInAccount(@RequestBody Account account) {
    return accountService.signIn(account);
  }

  @PostMapping("/signup")
  public void signUpAccount(@RequestBody Account account) {
    accountService.signUp(account);
  }
}
