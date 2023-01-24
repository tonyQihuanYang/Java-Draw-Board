package com.drawBoard.drawBoard.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

  Optional<Account> findByEmailAndPassword(String email, String password);
}
