package repository;

import entity.Quest;

import java.util.Map;
import java.util.Optional;

public interface QuestRepository {
    Optional<Quest> getQuestById(Long id);

    Map<String, Map<String, String>> getDescriptionQuest();

    Long getQuestionId(String questionText);


}
