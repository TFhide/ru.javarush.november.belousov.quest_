package service;

import entity.User;
import org.json.simple.JSONObject;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String ipAddress) {
        userRepository.addUser(ipAddress);
    }

    public void saveActionUser(String ipAddress) {
        userRepository.saveActionUser(ipAddress);
    }

    public void saveOfWin(String ipAddress) {
        userRepository.saveOfWin(ipAddress);
    }

    public void saveOfLose(String ipAddress) {
        userRepository.saveOfLose(ipAddress);
    }

    public boolean isUserInMemory(String ipAddress) {
        return userRepository.isUserInMemory(ipAddress);
    }

    public String getUserStatistic(String ipAddress) {
        JSONObject json = new JSONObject();
        User user = userRepository.getUser(ipAddress).get();
        json.put("ipAddress", user.getIpAddress());
        json.put("quantity", user.getQuantity());
        json.put("win", user.getWin());
        json.put("lose", user.getLose());
        return json.toString();
    }

    public boolean isValidIpAddress(String ipAddress) {
        return ipAddress != null ? true : false;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
