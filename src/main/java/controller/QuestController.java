package controller;

import controller.dispatcher.MethodType;
import controller.dispatcher.RequestMapping;
import service.QuestService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuestController {
    private final QuestService serviceQuest;
    private final UserService userService;


    public QuestController(QuestService questService, UserService userService) {
        this.serviceQuest = questService;
        this.userService = userService;
    }

    @RequestMapping(url = "/description", method = MethodType.GET)
    public void getDescriptionQuest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(serviceQuest.getDescriptionQuest().get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(url = "/view", method = MethodType.GET)
    public void showQuestion(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("ipAddress", request.getRemoteAddr());
        String ip = (String) session.getAttribute("ipAddress");
        if (userService.isValidIpAddress(ip) && !userService.isUserInMemory(ip)) {
            userService.addUser(ip);
            userService.saveActionUser(ip);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(serviceQuest.getFirstQuestion().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(url = "/handler", method = MethodType.POST)
    public void showOutcome(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String ip = (String) session.getAttribute("ipAddress");
        if (userService.isValidIpAddress(ip) && !userService.isUserInMemory(ip)) {
            userService.addUser(ip);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            if (serviceQuest.getJsonContainer(request).containsKey("outcome")) {
                if (serviceQuest.getJsonContainer(request).toJSONString().contains("Победа")) {
                    userService.saveOfWin(ip);
                    userService.saveActionUser(ip);
                } else {
                    userService.saveOfLose(ip);
                    userService.saveActionUser(ip);
                }
            }
            response.getWriter().write(serviceQuest.getJsonContainer(request).toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(url = "/statistic", method = MethodType.GET)
    public void getUserStatistic(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("ipAddress", request.getRemoteAddr());
        String ip = (String) request.getSession().getAttribute("ipAddress");
        if (userService.isValidIpAddress(ip) && !userService.isUserInMemory(ip)) {
            userService.addUser(ip);
            try {
                response.getWriter().write(userService.getUserStatistic(ip));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            response.getWriter().write(userService.getUserStatistic(ip));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

