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
import fi.haagahelia.surveysystem.domain.Question;
import fi.haagahelia.surveysystem.domain.QuestionRepository;
import fi.haagahelia.surveysystem.domain.Survey;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = {"http://localhost:5173", "https://survey-system-git-quest-project.2.rahtiapp.fi"})

@RestController 
public class SurveyRestController {
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;

    public SurveyRestController(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    @RequestMapping("/api/surveys")
    public List<Survey> findSurveys(){
        return surveyRepository.findAll();
    }

    @RequestMapping("/api/survey/{id}")
    public Optional<Survey> findSurvey(@PathVariable("id") Long surveyId) {
        return surveyRepository.findById(surveyId);
    }

    @RequestMapping("/api/questions/{id}")
    public List<Question> requestMethodName(@PathVariable("id") Long questionId) {
        return questionRepository.findBySurveyId(questionId);
    }

}

