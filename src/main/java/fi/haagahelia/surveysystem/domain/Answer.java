package fi.haagahelia.surveysystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question; 

    private Type type;
    private String answer;

    public Answer(){

    }

    public Answer(Question question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public Answer(String answer){
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
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
