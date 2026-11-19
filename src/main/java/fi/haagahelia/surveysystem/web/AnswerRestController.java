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

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AnswerRestController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerRestController(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;;
    }

    @PostMapping("/api/answer/{id}")
    public String addAnswer (@PathVariable Long id, @RequestBody String answer) {

        Question _question = questionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey not found"));

        Answer newAnswer = new Answer(_question, answer);

        answerRepository.save(newAnswer);

        return "Answer id: " + id + "Added to repo";
    }
}
