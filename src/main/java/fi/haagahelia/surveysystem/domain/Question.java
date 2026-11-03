package fi.haagahelia.surveysystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

enum type {
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
    private String description;
    private Long surveyId;
    private type type;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }
}

