package fi.haagahelia.surveysystem.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.surveysystem.domain.Answer;
import fi.haagahelia.surveysystem.domain.AnswerRepository;
import fi.haagahelia.surveysystem.domain.SurveyRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AnswerRestController {

    private final AnswerRepository answerRepository;

    public AnswerRestController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @PostMapping("/api/answer/{id}")
    public String addAnswer (@PathVariable Long id, @RequestBody String answer) {

        Answer newAnswer = new Answer(id, answer);

        answerRepository.save(newAnswer);

        return "Answer id: " + id + "Added to repo";
    }
}
