package entity;

import java.util.List;
import java.util.Objects;


public class Question {
    private final Long id;
    private final String text;
    private final String questionImageLink;
    private final List<Answer> answers;

    public Question(Long questionId, String questionName, String questionImageLink, List<Answer> answers) {
        this.id = questionId;
        this.text = questionName;
        this.questionImageLink = questionImageLink;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getQuestionImageLink() {
        return questionImageLink;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id)
                && Objects.equals(text, question.text)
                && Objects.equals(questionImageLink, question.questionImageLink)
                && Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, questionImageLink, answers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", questionImageLink='" + questionImageLink + '\'' +
                ", answers=" + answers +
                '}';
    }
}
