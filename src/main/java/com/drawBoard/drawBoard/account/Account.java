package com.drawBoard.drawBoard.account;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
  @Id
  @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
  private Long id;

  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String password;

  // @CreatedDate
  // private Instant createdDate;
  public Account() {
  }

  public Account(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public Account(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
