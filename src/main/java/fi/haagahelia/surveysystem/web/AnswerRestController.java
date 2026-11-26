package fi.haagahelia.surveysystem.web;

import fi.haagahelia.surveysystem.domain.QuestionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fi.haagahelia.surveysystem.domain.Answer;
import fi.haagahelia.surveysystem.domain.AnswerRepository;
import fi.haagahelia.surveysystem.domain.Question;
import fi.haagahelia.surveysystem.domain.Survey;
import fi.haagahelia.surveysystem.domain.SurveyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AnswerRestController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerRestController(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;;
    }

    @PostMapping("/api/answers/save")
    public List<Answer> saveAnswers(@RequestBody List<Answer> answers) {
        return answerRepository.saveAll(answers);
    }

    @GetMapping("/api/answers")
    public List<Answer> getAnswersBySurvey() {
        return answerRepository.findAll();
    }
    
    // löydä kaikki vastaukset tällä tietyllä kysymys id:llä
    // useampi vastaus yhteen kysymykseen
    @RequestMapping("/api/answer/{id}")
    public List<Answer> getAnswerById(@PathVariable("id") Long id) {
        return answerRepository.findByQuestionId(id);
    }


    

    
}
