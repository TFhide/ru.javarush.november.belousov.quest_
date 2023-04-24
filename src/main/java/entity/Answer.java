package entity;


import java.util.Objects;

public class Answer {
    private final Long id;
    private final String text;
    private String outcome;
    private Long nextQuestionId;

    public Answer(Long id, String name, Long nextQuestionId) {
        this.id = id;
        this.text = name;
        this.nextQuestionId = nextQuestionId;
    }

    public Answer(Long id, String text, String outcome) {
        this.id = id;
        this.text = text;
        this.outcome = outcome;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public String getOutcome() {
        return outcome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id)
                && Objects.equals(text, answer.text)
                && Objects.equals(outcome, answer.outcome)
                && Objects.equals(nextQuestionId, answer.nextQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, outcome, nextQuestionId);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", outcome='" + outcome + '\'' +
                ", nextQuestionId=" + nextQuestionId +
                '}';
    }
}
