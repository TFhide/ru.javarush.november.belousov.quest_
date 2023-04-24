package repository;

import entity.Answer;
import entity.Quest;
import entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;

class InMemoryQuestRepositoryTest {

    QuestRepository questRepository;
    List<Quest> quests;
    Map<Long, Quest> ID_TO_QUEST = new HashMap<>();

    @BeforeEach
    void SetUp() {
        questRepository = new InMemoryQuestRepository();
//        mockRepository = Mockito.mock(QuestRepository.class);
        quests = Arrays.asList(new Quest(1L, "Путешествие принца Персии: Легенда о затерянной цитадели", Arrays.asList(
                new Question(1L, "Ты готов отправиться в путешествие вместе с принцем Персии на поиски затерянной цитадели?",
                        "img/PrinceOfPersia/first_scene.png", Arrays.asList(new Answer(1L, "Да, я готов(а) к приключению!", 2L),
                        new Answer(2L, "Нет, я боюсь рисковать своей жизнью.",
                                "Ты подвел принца Персии, он расчитывал на твою помощь. Поражение!"))),
                new Question(2L, "Ты и принц Персии оказались в засаде. Как поступишь?", "img/PrinceOfPersia/second_scene.png",
                        Arrays.asList(new Answer(1L, "Попытаюсь отбиться от врагов.", 3L), new Answer(2L,
                                "Попытаюсь скрыться и обойти врагов.", "Из-за ошибочного решения скрыться и обойти врагов," +
                                " оставив принца Персии и его воинов сражаться с врагом лицом к лицу, погибли все, включая принца Персии. Поражение!"))),
                new Question(3L, "Вы встретили загадочного старца, который предлагает помочь вам найти цитадель. Как поступишь?",
                        "img/PrinceOfPersia/third_scene.png", Arrays.asList(new Answer(1L, "Приму помощь старца.", 5L),
                        new Answer(2L, "Откажусь от помощи и продолжу искать цитадель самостоятельно.", "Отказавшись от помощи" +
                                " старца, потеряна ценная информацию о местонахождении цитадели, войско заблудилось и погибло. Поражение!"))))));
        for (int i = 0; i < quests.size(); i++) {
            ID_TO_QUEST.put(quests.get(i).getId(), quests.get(i));
        }
    }

    @Test
    void getQuestById_shouldReturnQuest_whenQuestExists()
    {
        Optional<Quest> questById = questRepository.getQuestById(1L);
        assertTrue(questById.isPresent());
    }

    @Test
    void getDescriptionQuest__whenDescriptionExist()
    {
        Map<String, Map<String, String>> descriptionQuest = questRepository.getDescriptionQuest();
        assertFalse(descriptionQuest.isEmpty());
    }

//    @Test
//    void getQuestionId_shouldReturnOptionalEmpty_whenQuestionTextNotFoundQuestion()
//    {
//        Optional<Long> randomQuestion = questRepository.getQuestionId("random question");
//        assertFalse(randomQuestion.isPresent());
//    }
//
//    @Test
//    void getQuestionId_shouldReturnIdQuestion_whenQuestionExist()
//    {
//        Question question = quests.get(0).getQuestions().get(0);
//        Optional<Long> questionId = questRepository.getQuestionId(question.getText());
//        assertEquals(question.getId(), questionId.get());
//    }
//
//        assertEquals(questById.get(), ID_TO_QUEST.get(1L));
//        when(mockRepository.getQuestById(1L)).thenReturn(Optional.ofNullable(ID_TO_QUEST.get(1L)));
//        assertEquals(ID_TO_QUEST.get(1L), mockRepository.getQuestById(1L).get());


//    @Test
//    void getQuestById_whenQuestDoesNotExist() {
//        Optional<Quest> questById = questRepository.getQuestById(null);
//        assertFalse(questById.isPresent());
//        when(mockRepository.getQuestById(1L)).thenReturn(Optional.empty());
//        assertThrows(NoSuchElementException.class, () -> inMemoryQuestRepository.getQuestById(1L).get());
        // используем mockRepository и questService для тестирования



//        // Создаем экземпляр реального класса
//            InMemoryQuestRepository repository = new InMemoryQuestRepository();
//
//            // Добавляем несколько квестов в репозиторий
//            List<Quest> quests = Arrays.asList(
//                    new Quest(1L, "Quest 1", Collections.emptyList()),
//                    new Quest(2L, "Quest 2", Collections.emptyList()),
//                    new Quest(3L, "Quest 3", Collections.emptyList())
//            );
//            for (Quest quest : quests) {
//                repository.save(quest);
//            }
//
//            // Проверяем, что метод getQuestById() возвращает правильный квест
//            Optional<Quest> result = repository.getQuestById(2L);
//            assertTrue(result.isPresent());
//            assertEquals("Quest 2", result.get().getTitle());
//    }

}