package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class UsersControllerTest {

    private UserController usersController;
    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp() {
        usersRepository = mock(UsersRepository.class);
        usersController = new UsersController(usersRepository);
    }

    @Test
    public void testGetAllUsers() {
        // Arrange
        List<Users> usersList = Arrays.asList(
            new Users(1L, "Madura", "MainRoad", "2000-11-12", "0783587735", "Madura1@"),
            new Users(2L, "John", "SecondStreet", "1995-05-20", "1234567890", "John123")
        );
        when(usersRepository.findAll()).thenReturn(usersList);

        // Act
        ResponseEntity<List<Users>> response = usersController.getAllUsers();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200); // Assuming HTTP 200 for success
        assertThat(response.getBody()).isEqualTo(usersList);
    }

    // Add other test methods related to UsersController here.
}
