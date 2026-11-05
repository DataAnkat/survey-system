package fi.haagahelia.surveysystem.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.surveysystem.domain.SurveyRepository;
import fi.haagahelia.surveysystem.domain.Survey;



@RestController 

public class SurveyRestController {
    private final SurveyRepository surveyRepository;

    SurveyRestController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @GetMapping("/api/surveys")
    public List<Survey> findsurveys(){
        return surveyRepository.findAll();
    }

    @GetMapping("/api/surveys/{id}")
    public Optional<Survey> onesurvey(@PathVariable("id") long id){
        return surveyRepository.findById(id);
    }

}

