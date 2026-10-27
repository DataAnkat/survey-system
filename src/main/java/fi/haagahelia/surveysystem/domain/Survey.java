package fi.haagahelia.surveysystem.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Survey {

    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String question;

    private List<String> questions;

    public Survey() {
    }

    public Survey(String name, List<String> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey [name=" + name + ", questions=" + questions + "]";
    }
        
}
