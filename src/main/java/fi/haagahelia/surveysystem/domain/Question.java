package fi.haagahelia.surveysystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

enum Type {
    TEXT,
    CHECKBOX_MULTIPLE_CHOICE,
    RADIOHEAD_MULTIPLE_CHOICE,
    SCALE
}

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String question;
    private Long surveyId; //Survey survey instead of Long surveyId (Same as Book - Category)
    private Type type;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

