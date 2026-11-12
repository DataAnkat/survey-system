package fi.haagahelia.surveysystem.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.surveysystem.domain.SurveyRepository;
import fi.haagahelia.surveysystem.domain.Survey;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController 
public class SurveyRestController {
    private final SurveyRepository surveyRepository;

    public SurveyRestController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @RequestMapping("/api/surveys")
    public List<Survey> findSurveys(){
        return surveyRepository.findAll();
    }

    @RequestMapping("/api/survey/{id}")
    public Optional<Survey> findSurvey(@PathVariable("id") Long surveyId) {
        return surveyRepository.findById(surveyId);
    }

    

}
