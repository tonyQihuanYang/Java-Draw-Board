package com.drawBoard.drawBoard.account;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.SequenceGenerator;
// import jakarta.persistence.Table;

// @Entity
// @Table
public class Account{
  // @Id
  // @SequenceGenerator(
  //   name = "account_sequence",
  //   sequenceName = "account_sequence",
  //   allocationSize = 1
  // )
  // @GeneratedValue(
  //   strategy = GenerationType.SEQUENCE,
  //   generator =  "account_sequence"
  // )
  private Long id;
  private String email;

  public Account(Long id, String email) {
    this.id = id;
    this.email= email;
  }
}
