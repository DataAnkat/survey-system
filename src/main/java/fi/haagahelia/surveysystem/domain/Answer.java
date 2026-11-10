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
    private type type;
    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> answer = new ArrayList <> ();

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
    public type getType() {
        return type;
    }
    public void setType(type type) {
        this.type = type;
    }
    public List<String> getAnswer() {
        return answer;
    }
    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}   
