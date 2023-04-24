package repository;

import entity.Answer;
import entity.Quest;
import entity.Question;

import java.util.*;

public class InMemoryQuestRepository implements QuestRepository {

    private static final Map<String, Map<String, String>> descriptionQuest;
    private static final List<Quest> quests;
    private static final Map<Long, Quest> ID_TO_QUEST = new HashMap<>();

    static {
    descriptionQuest = new HashMap<String, Map<String, String>>() {{
    put("PrinceOfPersia", new HashMap<String, String>() {{
    put("image/descriptionImage.png", "Добро пожаловать в захватывающий мир фантастических приключений" +
     " и опасных испытаний! Вы готовы отправиться вместе с принцем Персии на поиски затерянной цитадели? Этот квест" +
     " полон увлекательных загадок, незабываемых встреч и сражений с опасными противниками. Вас ждет захватывающее " +
     "приключение, полное экшена и неожиданных поворотов сюжета. Сможете ли вы пройти все испытания, чтобы найти " +
     "затерянную цитадель и разгадать ее тайны? Предстоит много опасных решений и рискованных действий, но награда " +
     "стоит того - несметные богатства и бесценные знания ждут того, кто сможет достичь цели. Приготовьтесь к " +
     "захватывающему приключению, которое оставит незабываемые впечатления на всю жизнь!");
            }});
        }};

    quests = Arrays.asList(new Quest(1L, "Путешествие принца Персии: Легенда о затерянной цитадели",
      Arrays.asList(new Question(1L, "Ты готов отправиться в путешествие вместе с принцем Персии" +
         " на поиски затерянной цитадели?", "image/first_scene.png", Arrays.asList(
         new Answer(1L, "Да, я готов(а) к приключению!", 2L), new Answer(2L,
         "Нет, я боюсь рисковать своей жизнью.", "Ты подвел принца Персии, он расчитывал на твою помощь." +
          " Поражение!"))),
      new Question(2L, "Ты и принц Персии оказались в засаде. Как поступишь?",
              "image/second_scene.png", Arrays.asList(new Answer(1L, "Попытаюсь " +
          "отбиться от врагов.", 3L), new Answer(2L, "Попытаюсь скрыться и обойти врагов.",
          "Из-за ошибочного решения скрыться и обойти врагов, оставив принца Персии и его воинов сражаться с" +
           " врагом лицом к лицу, погибли все, включая принца Персии. Поражение!"))),
      new Question(3L, "Вы встретили загадочного старца, который предлагает помочь вам найти " +
           "цитадель. Как поступишь?", "image/third_scene.png", Arrays.asList(
           new Answer(1L, "Приму помощь старца.", 5L), new Answer(2L, "Откажусь от" +
           " помощи и продолжу искать цитадель самостоятельно.", "Отказавшись от помощи старца, потеряна ценная" +
           " информацию о местонахождении цитадели, войско заблудилось и погибло. Поражение!"))),
      new Question(5L, "Вы прибыли к старинному храму, который, как вы думаете, может быть ключом к " +
           "нахождению цитадели. Что будешь делать?", "image/fourth_scene.png", Arrays.asList(
           new Answer(1L, "Исследовать храм, чтобы найти нужную информацию.", 7L), new Answer(2L,
           "Пройти мимо храма и продолжить поиски цитадели.", "Упущена возможность найти ключ к нахождению цитадели. " +
            "Поражение!"))),
      new Question(7L, "Вы нашли затерянную цитадель, но она охраняется стражами. Как действуешь?",
              "image/final_scene.png", Arrays.asList(new Answer(1L, "Начну сражение со стражами.",
            "Умение действовать не только силой, но и сообразительностью, могло бы помочь достичь цели, а не привести к " +
             "погибели. Поражение!"), new Answer(2L, "Попробую обойти стражей и незаметно проникнуть внутрь цитадели.",
             "В далекие времена правительство страны переживало трудные времена. Империя была раздроблена, властью завладели " +
             "коррумпированные чиновники, а народ страдал от бедности и безработицы. В такое время на свет появилась легенда о " +
             "затерянной цитадели, которая хранила в себе несметные богатства и могла принести счастье и процветание всей стране. " +
             "Но никто не мог найти ее местонахождение. Однажды принц Персии решил отправиться на поиски цитадели, чтобы вернуть " +
             "своей стране благоденствие и порядок. Он нашел смельчака, готового присоединиться к нему в этом опасном приключении. " +
             "Вместе они прошли через тысячи опасностей, сражались со злыми врагами и обходили смертельные ловушки. Они встретили " +
             "загадочного старца, который помог им в поисках, и нашли старинный храм, в котором была скрыта важная информация. " +
             "Наконец, они нашли затерянную цитадель, которую охраняли многочисленные стражи. Принцу Персии и его войску удалось " +
             "незаметно проникнуть внутрь цитадели при помощи смекалки, победить стражу, разгадать тайну затерянной цитадели " +
             "и принести своей стране мир и процветание. Победа!"))))),
      new Quest(2L, "Побег из запертой комнаты", Arrays.asList(new Question(1L, "not ready",
                        "not ready", Arrays.asList(new Answer(1L, "not ready", 1L),
                        new Answer(2L, "not ready", 1L))))),
      new Quest(3L, "Потерянный артефакт темных времен", Arrays.asList(new Question(1L, "not ready",
                        "not ready", Arrays.asList(new Answer(1L, "not ready", 1L),
                        new Answer(2L, "not ready", 1L))))),
      new Quest(4L, "Исследование заброшенного замка", Arrays.asList(new Question(1L, "not ready",
                        "not ready", Arrays.asList(new Answer(1L, "not ready", 1L),
                        new Answer(2L, "not ready", 1L))))),
      new Quest(5L, "Охота на сокровища пиратов", Arrays.asList(new Question(1L, "not ready",
                        "not ready", Arrays.asList(new Answer(1L, "not ready", 1L),
                        new Answer(2L, "not ready", 1L))))));

        for (int i = 0; i < quests.size(); i++) {
            ID_TO_QUEST.put(quests.get(i).getId(), quests.get(i));
        }
    }

    @Override
    public Optional<Quest> getQuestById(Long id) {
        Quest result = null;
        for (Map.Entry<Long, Quest> entry : ID_TO_QUEST.entrySet()) {
            if (Objects.equals(entry.getKey(), id))
                result = entry.getValue();
        }
        return Optional.ofNullable(result);
    }

    @Override
    public Map<String, Map<String, String>> getDescriptionQuest() {
        return descriptionQuest;
    }

    @Override
    public Long getQuestionId(String questionText) {
        if (!(ID_TO_QUEST.isEmpty())) {
            for (Map.Entry<Long, Quest> entry : ID_TO_QUEST.entrySet()) {
                for (Question question : entry.getValue().getQuestions()) {
                    if (question.getText().equals(questionText))
                        return question.getId();
                }
            }
        }
        return null;
    }
}
