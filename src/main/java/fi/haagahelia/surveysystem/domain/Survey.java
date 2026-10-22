package fi.haagahelia.surveysystem.domain;

import java.util.List;

public class Survey {

    private String name;
    private List<String> questions;

    public Survey(String name, List<String> questions) {
        this.name = name;
        this.questions = questions;
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

    
}
