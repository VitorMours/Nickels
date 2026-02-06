package com.vprofit.backend.models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.vprofit.backend.models.User;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.Table;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;
import jakarta.persistence.Entity;


/**
 * Classe de teste do modelo do usuario para verificar o comportamento presente  
 * dentro dos campos da entidade, e na forma como os metodos se comportam
 */ 
public class UserModelTest {

    private User validUser;

    @BeforeEach 
    void setUp(){
        validUser = new User(
            "Joao Vitor",
            "jvrezendemoura@gmail.com",
            "123213sad!"
        );
    }

    @Test 
    @DisplayName("Validar que o usuario nao pode ser criado com dados vazios")
    void validarQueoUsuarioNaoPodeSerCriadoComDadosVazios(){
        IllegalArgumentException nameException = assertThrows(
            IllegalArgumentException.class, () -> new User(
                "",
                "email@emai.com",
                "testesenhha"
            )
        );
        IllegalArgumentException emailException = assertThrows(
            IllegalArgumentException.class,
            () -> new User(
                "TEste",
                "",
                "testesenha"
            )
        );
        IllegalArgumentException passwordException = assertThrows(
            IllegalArgumentException.class,
            () -> new User(
                "Teste", 
                "teste@teste.com", 
                ""
            )
        );
        assertEquals("O usuario nao pode ser criado sem nome", nameException.getMessage());
        assertEquals("O usuario nao pode ser criado sem email", emailException.getMessage());
        assertEquals("O usuario nao pode ser criado sem senha", passwordException.getMessage());
    }

    @Test 
    @DisplayName("Validar que o usuario nao pode ser criado com valores nulos")
    void validarQueoUsuarioNaoPodeSerCriadoComValoresNulos(){
        IllegalArgumentException nameException = assertThrows(
            IllegalArgumentException.class, 
            () -> new User(
                null, 
                "teste@teste.com",
                "senhateste"
            )
        );
        IllegalArgumentException emailException = assertThrows(
            IllegalArgumentException.class, 
            () -> new User(
                "teste da silva",
                null, 
                "senhateste"
            )    
        );
        IllegalArgumentException passwordException = assertThrows(
            IllegalArgumentException.class, 
            () -> new User(
                "teste da suilva",
                "teste@teste.com",
                null
            )
        );
        assertEquals("O usuario nao pode ser criado sem nome", nameException.getMessage());
        assertEquals("O usuario nao pode ser criado sem email", emailException.getMessage());
        assertEquals("O usuario nao pode ser criado sem senha", passwordException.getMessage());
    }

    @Test 
    @DisplayName("A entidade possui os campos necessarios")
    void entidadePossuiOsCamposNecessarios(){
        Class<User> clazz = User.class;
        List<String> waitedFields = Arrays.asList("name","email","createdAt","updatedAt","password","isActive");
        for (String campo : waitedFields){
            assertDoesNotThrow(() -> {
                Field field = clazz.getDeclaredField(campo);
                assertNotNull(field);
            }, "Campo nao encontrado: " + campo);
        }
    }

    /**
     * Verifica se a classe possui os metodos esperados
     * para que o funcionamento da classe se de de maneira correta
     */
    @Test
    @DisplayName("A Entidade possui getters e setters ")
    void entidadePossuiGettersESetters(){
        List<String> methodNameList = Arrays.asList(
            "getName","getPassword","getEmail","getIsActive",
            "setName","setPassword","setEmail","setIsActive");
        Class<User> clazz = User.class;
        List<String> methods = Arrays.stream(clazz.getMethods())
                                .map(Method::getName)
                                .collect(Collectors.toList());
        for(String method : methodNameList){
            assertTrue(methods.contains(method));
        }
    }

    @Test 
    @DisplayName("O funcionamento do getters e setters esta sendo dado de maneira correta")
    void funcionamentoDosGetterseSettersEstaCorreto(){
        User newUser = new User("Teste","teste.dasilva@gmail.com","123asd!");
        String userName = newUser.getName();
        String userEmail = newUser.getEmail();
        String userPassword = newUser.getPassword();
        boolean userStatus = newUser.getIsActive();
        // Testar os Getters
        assertEquals(userName, "Teste");
        assertEquals(userEmail, "teste.dasilva@gmail.com");
        assertEquals(userPassword, "123asd!");
        assertEquals(userStatus, true);

        // Testar os Setters
        newUser.setName("Pietro");
        newUser.setPassword("123123123!");
        newUser.setEmail("pietro.juan@gmail.com");
        newUser.setIsActive(false);
        String newUserName = newUser.getName();
        String newUserEmail = newUser.getEmail();
        String newUserPassword = newUser.getPassword();
        boolean newUserStatus = newUser.getIsActive();
        assertEquals(newUserName, "Pietro");
        assertEquals(newUserEmail, "pietro.juan@gmail.com");
        assertEquals(newUserPassword, "123123123!");
        assertEquals(newUserStatus, false);
    }

    @Test 
    @DisplayName("Impedir de setar valores vazios nos campos")
    void impedirDeSetarValoresVaziosNosCampos(){
        User newUser = new User(
            "Lucas",
            "teste@teste.com",
            "123213213213asd!"
        );       
    
        IllegalArgumentException nullEmailException = assertThrows(
            IllegalArgumentException.class,
            () -> newUser.setEmail(null)
        );
        assertEquals(nullEmailException.getMessage(), "The new value for email cannot be empty or null");

        IllegalArgumentException nullNameException = assertThrows(
            IllegalArgumentException.class, 
            () -> newUser.setName(null)
        );
        assertEquals(nullNameException.getMessage(), "The new value for name cannot be empty or null");

        IllegalArgumentException nullPasswordException = assertThrows(
            IllegalArgumentException.class, 
            () -> newUser.setPassword(null)
        );
        assertEquals(nullPasswordException.getMessage(), "The new value for password cannot be empty or null");
    }

}

