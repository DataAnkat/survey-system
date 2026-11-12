package fi.haagahelia.surveysystem.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// enum type {
//     TEXT,
//     CHECKBOX_MULTIPLE_CHOICE,
//     RADIOHEAD_MULTIPLE_CHOICE,
//     SCALE
// }

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    private Long surveyId;
    private Type type;
    private String answer;

    public Answer(Long surveyId, String answer){
        this.surveyId = surveyId;
        this.answer = answer;
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
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}   
