package fi.haagahelia.surveysystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
    private Type type;

    public Question() {
        
    }

    public Question(String question, Survey survey, Type type) {
        this.question = question;
        this.survey = survey;
        this.type = type;
    }

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

    public Survey getSurvey() {
        return survey;
    }

    public void setSurveyId(Survey survey) {
        this.survey = survey;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

