package repository;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void SetUp()
    {
      userRepository = new InMemoryUserRepository();
      userRepository.addUser("192.168.1.1");
    }

    @Test
    void addUser()
    {
        List<User> users = userRepository.getUsers();
        assertTrue(users.contains(new User("192.168.1.1")));
    }

        @Test
    void saveActionUser()
        {
            userRepository.saveActionUser("192.168.1.1");
            List<User> users = userRepository.getUsers();
            for (User user : users) {
                if (user.getIpAddress().equals("192.168.1.1")) {
                    assertEquals(1, user.getQuantity()); }
                else {

                }
            }
        }

    @Test
    void saveActionUser_return() {
        userRepository.saveActionUser("192.168.1.1");
        User user = userRepository.getUser("192.168.1.1").get();
        assertEquals(1, user.getQuantity());
    }

        @Test
    void saveOfWin() {
            userRepository.saveOfWin("192.168.1.1");
            User user = userRepository.getUser("192.168.1.1").get();
            assertEquals(1, user.getWin());
    }

    @Test
    void saveOfLose() {
        userRepository.saveOfLose("192.168.1.1");
        User user = userRepository.getUser("192.168.1.1").get();
        assertEquals(1, user.getLose());
    }

        @Test
    void isUserInMemory_shouldReturnTrue_whenUserExist() {
            userRepository.addUser("192.168.1.1");
            List<User> users = userRepository.getUsers();
            assertTrue(users.contains(new User("192.168.1.1")));
    }

        @Test
    void getUser_shouldReturnUser_whenUserExist() {
            userRepository.addUser("192.168.1.1");
            List<User> users = userRepository.getUsers();
            for (User user : users) {
                if (user.getIpAddress().equals("192.168.1.1"))
                    assertEquals("192.168.1.1", user.getIpAddress());
            }
    }

}