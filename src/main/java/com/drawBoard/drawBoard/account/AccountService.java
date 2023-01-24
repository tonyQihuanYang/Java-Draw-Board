package com.drawBoard.drawBoard.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  @Autowired
  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void signUp(Account account) {
    Optional<Account> accountInDB = accountRepository.findByEmailAndPassword(account.getEmail(),
        account.getPassword());
    if (accountInDB.isPresent()) {
      throw new IllegalStateException("Email Existed");
    }
    Account newAccount = new Account(account.getEmail(), account.getPassword());
    accountRepository.save(newAccount);
  }

  public String signIn(Account account) {
    Optional<Account> accountInDB = accountRepository.findByEmailAndPassword(account.getEmail(),
        account.getPassword());
    if (!accountInDB.isPresent()) {
      throw new IllegalStateException("Account Not Existed");
    }
    return "Ok";
  }
}
