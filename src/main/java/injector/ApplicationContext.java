package injector;

import controller.QuestController;
import controller.dispatcher.HandlerMethod;
import controller.dispatcher.RegisterForControllers;
import repository.InMemoryQuestRepository;
import repository.InMemoryUserRepository;
import repository.QuestRepository;
import repository.UserRepository;
import service.QuestService;
import service.UserService;

import java.util.Map;


public class ApplicationContext {

    private ApplicationContext() {
    }

    private static final QuestRepository QUEST_REPOSITORY = new InMemoryQuestRepository();
    private static final QuestService QUEST_SERVICE = new QuestService(QUEST_REPOSITORY);
    private static final UserRepository USER_REPOSITORY = new InMemoryUserRepository();
    private static final UserService USER_SERVICE = new UserService(USER_REPOSITORY);
    private static final QuestController QUEST_CONTROLLER = new QuestController(QUEST_SERVICE, USER_SERVICE);

    public static final Map<String, HandlerMethod> URL_TO_HANDLER =
            new RegisterForControllers().register(QUEST_CONTROLLER);
}
