package service;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.InMemoryUserRepository;
import repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    UserService userService;

    UserService mock;

    @BeforeEach
    void SetUp()
    {
        userService = new UserService(new InMemoryUserRepository());
        userService.addUser("190.11.22.33");
        userService.addUser("192.11.22.33");
        userService.addUser("191.11.22.33");
        mock = Mockito.mock(UserService.class);
    }

    @Test
    void addUser_shouldReturnUser_whenUserExist()
    {
        List<User> users = userService.getUserRepository().getUsers();
        assertTrue(users.contains(new User("192.11.22.33")));
    }

    @Test
    void saveActionUser_checkQuantityInvokeThisMethod()
    {
        mock.saveActionUser("191.11.22.33");
        verify(mock, times(1)).saveActionUser("191.11.22.33");
    }

    @Test
    void saveActionUser()
    {
        userService.saveActionUser("191.11.22.33");
        User user = userService.getUserRepository().getUser("191.11.22.33").get();
        assertEquals(1, user.getQuantity());
    }

    @Test
    void saveOfWin()
    {
        userService.saveOfWin("190.11.22.33");
        User user = userService.getUserRepository().getUser("190.11.22.33").get();
        assertEquals(1, user.getWin());
    }

    @Test
    void saveOfLose()
    {
        userService.saveOfLose("192.11.22.33");
        User user = userService.getUserRepository().getUser("192.11.22.33").get();
        assertEquals(1, user.getLose());
    }

    @Test
    void isUserInMemory_shouldReturnTrue_whenUserExist()
    {
        boolean userInMemory = userService.isUserInMemory("192.11.22.33");
        assertTrue(userInMemory);
    }

    @Test
    void isUserInMemory_shouldReturnFalse_whenUserDoesNotExist()
    {
        boolean userInMemory = userService.isUserInMemory("198.111.22.33");
        assertFalse(userInMemory);
    }

    @Test
    void getUserStatistic_shouldReturnTrue_whenUserStatisticExist()
    {
        String userStatistic = userService.getUserStatistic("192.11.22.33");
        assertTrue(userStatistic.contains("ipAddress"));
        assertTrue(userStatistic.contains("quantity"));
        assertTrue(userStatistic.contains("win"));
        assertTrue(userStatistic.contains("lose"));
    }

    @Test
    void isValidIpAddress_shouldReturnTrue_whenIpAddressIsValid()
    {
        boolean result = userService.isValidIpAddress("192.11.22.33");
        assertTrue(result);
    }

    @Test
    void isValidIpAddress_shouldReturnFalse_whenIpAddressIsInvalid()
    {
        boolean result = userService.isValidIpAddress(null);
        assertFalse(result);
    }
}