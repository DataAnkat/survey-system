package fi.haagahelia.surveysystem.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Survey {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> questions = new ArrayList<>();

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
