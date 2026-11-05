package fi.haagahelia.surveysystem.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.surveysystem.domain.SurveyRepository;
import fi.haagahelia.surveysystem.domain.Survey;



@RestController 

public class SurveyRestController {
    private final SurveyRepository surveyRepository;

    SurveyRestContoller(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    @GetMapping("/api/surveys")
    public List<Survey> findsurveys(){
        return SurveyRepository.findAll();
    }
}
