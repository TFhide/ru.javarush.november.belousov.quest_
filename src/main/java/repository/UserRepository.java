package repository;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getUsers();

    boolean isUserInMemory(String ipAddress);

    void addUser(String ipAddress);

    void saveActionUser(String ipAddress);

    void saveOfWin(String ipAddress);

    void saveOfLose(String ipAddress);

    Optional<User> getUser(String ipAddress);

}
