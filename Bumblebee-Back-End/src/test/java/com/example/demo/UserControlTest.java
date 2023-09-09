import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class UsersControllerTest {

    private UsersController usersController;
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

    @Test
    public void testGetUserById() {
        // Arrange
        Users user = new Users(1L, "Madura", "MainRoad", "2000-11-12", "0783587735", "Madura1@");
        when(usersRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        ResponseEntity<Users> response = usersController.getUserById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200); // Assuming HTTP 200 for success
        assertThat(response.getBody()).isEqualTo(user);
    }

    // Add similar tests for other controller methods (e.g., createUser, updateUser, deleteUser).
}
