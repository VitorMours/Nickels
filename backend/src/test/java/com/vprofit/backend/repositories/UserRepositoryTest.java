
package com.vprofit.backend.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.vprofit.backend.models.User;

@DataJpaTest
public class UserRepositoryTest{

  @Autowired
  private UserRepository userRepository;

  @Test 
  void deveEncontrarUsuarioPeloEmail(){
    User user = new User(
      "Joao Vitor",
      "jvrezendemoura@gmail.com",
      "123123asd!");
    userRepository.save(user);

    Optional<User> result = userRepository.findByEmail("jvrezendemoura@gmail.com");
    assertTrue(result.isPresent());
    assertEquals("jvrezendemoura@gmail.com", result.get().getEmail());
    assertInstanceOf(Date.class, result.get().getCreatedAt());
  }

  @Test 
  @DisplayName("Verifica quantidade de registros dentro do banco de dados")
  void verificaQuantidadeDeRegistrosDentroDoBancoDeDados(){
    Integer quantity = (int) userRepository.count();
    assertEquals(quantity, 0);
  }




}