package service;

import entity.Quest;
import entity.Question;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryQuestRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QuestServiceTest {
    QuestService questService;
    @BeforeEach
    void setUp()
    {
        questService = new QuestService(new InMemoryQuestRepository());
    }

    @Test
    void getDescriptionQuest_shouldReturnTrue_whenDescriptionAndImageExit()
    {
        String descriptionQuest = questService.getDescriptionQuest().get();
        assertTrue(descriptionQuest.contains("description"));
        assertTrue(descriptionQuest.contains("image"));
    }

    @Test
    void getDescriptionQuest_shouldReturnTrue_whenDescriptionAndImageAreNotExit()
    {
        Optional<String> descriptionQuest = questService.getDescriptionQuest();
        assertFalse(descriptionQuest.isEmpty());
    }

    @Test
    void getFirstQuestion_shouldReturnFalse_whenJSONFirstQuestionDoesNotContainsKeys()
    {
        JSONObject firstQuestion = questService.getFirstQuestion();
        assertTrue(firstQuestion.containsKey("question"));
        assertTrue(firstQuestion.containsKey("answer1"));
        assertTrue(firstQuestion.containsKey("answer2"));
        assertTrue(firstQuestion.containsKey("image"));
    }

    @Test
    void getFirstQuestion_shouldReturnFalse_whenJSONFirstQuestionIsEmpty()
    {
        JSONObject firstQuestion = questService.getFirstQuestion();
        assertFalse(firstQuestion.isEmpty());
    }

    @Test
    void getQuestionId_shouldReturnQuestion_whenQuestionExist()
    {
        Long number = 1L;
        Long questionId = questService.getQuestionId(
                "Ты готов отправиться в путешествие вместе с принцем Персии на поиски затерянной цитадели?");
        assertEquals(number, questionId);
    }

    @Test
    void getQuestionId_shouldReturnNull_whenQuestionNotExist()
    {
        assertNull(questService.getQuestionId(""));
        assertNull(questService.getQuestionId("Когда будет исследовать заброшенный замок?"));
    }

    @Test
    void getQuestion_shouldReturnNull_whenQuestDoesNotExist()
    {
        assertNull(questService.getQuestion(2L, 3L));
        assertNull(questService.getQuestion(1L, 10L));
    }

    @Test
    void getNextQuestion_shouldReturnNull_whenNextQuestionDoesNotExist()
    {
        Object nextQuestion = questService.getNextQuestion(1L, "Когда будет исследовать заброшенный замок?", 2L);
        assertEquals(null, nextQuestion);
    }

    @Test
    void getNextQuestion_shouldReturnNextQuestion_whenQuestionExist()
    {
        Question nextQuestion = (Question) questService.getNextQuestion(
                1L, "Ты и принц Персии оказались в засаде. Как поступишь?", 1L);
        assertEquals(questService.getQuestion(1L, 3L), nextQuestion);
    }

    @Test
    void checkResultOnTrueOrFalse_shouldReturnTrue_whenQuestionIsQuestionOfClass()
    {
        boolean result = questService.checkResultOnTrueOrFalse(questService.getNextQuestion(
                1L, "Ты и принц Персии оказались в засаде. Как поступишь?", 1L));
        assertTrue(result);
    }

//    @Test
//    void getJsonContainer()
//    {
//        questService.getJsonContainer()
//
//    }

    @Test
    void getQuestByID_shouldReturnQuest_whenQuestExist()
    {
        Quest questByID = questService.getQuestByID(1L);
        assertTrue(Optional.of(questByID).isPresent());
    }

    @Test
    void getQuestByID_shouldReturnNull_whenQuestDoesNotExist()
    {
        Quest questByID = questService.getQuestByID(10L);
        assertNull(questByID);
    }
}