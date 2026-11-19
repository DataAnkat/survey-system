package fi.haagahelia.surveysystem.web;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.surveysystem.domain.Answer;
import fi.haagahelia.surveysystem.domain.AnswerRepository;
import fi.haagahelia.surveysystem.domain.Question;
import fi.haagahelia.surveysystem.domain.QuestionRepository;
import fi.haagahelia.surveysystem.domain.Survey;
import fi.haagahelia.surveysystem.domain.SurveyRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SurveyController {

    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    SurveyController(SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }
    //Luodaan survey
    @GetMapping("/createSurvey")
    public String createSurvey() {
        return "createSurvey";
    }

    //Haetaan survey id:n mukaan
    @GetMapping("/survey/{id}")
    public String survey(@PathVariable Long id, Model model) {

        Survey survey = surveyRepository.findById(id).orElseThrow();
        List<Question> questions = questionRepository.findBySurvey(survey);

        model.addAttribute("survey", survey);
        model.addAttribute("questions", questions);
        return "survey";
    }

    //Tallennetaan survey
    @PostMapping("/saveSurvey")
    public String saveSurvey(Survey survey, @RequestParam(name =  "questionTexts", required = false) List<String> questionTexts) {
        Survey savedSurvey = surveyRepository.save(survey);

        List<Question> questions = new ArrayList<Question>();

        if (questionTexts != null) {
            for (String text : questionTexts) {
                Question question = new Question(text, survey, null);

                questions.add(question);
            }
        }

        questionRepository.saveAll(questions);

        return "redirect:/survey/" + savedSurvey.getId();
    }

    //Haetaan surveyt 
    @GetMapping("/surveyList")
    public String surveyList(Model model) {
        model.addAttribute("Surveys", surveyRepository.findAll());
        return "surveyList";
    }
    
    // Muokataan surveyta id:n mukaan
    @GetMapping("/editSurvey/{id}")
    public String editSurvey(@PathVariable("id") Long id, Model model) {
        Survey surveyToEdit = surveyRepository.findById(id).orElseThrow();
        List<Question> questions = questionRepository.findBySurvey(surveyToEdit);

        model.addAttribute("survey", surveyToEdit);
        model.addAttribute("questions", questions);
        return "editSurvey"; 
    }

    @GetMapping("/deleteSurvey/{id}")
    public String confirmDelete(@PathVariable("id") Long id, Model model) {
        Survey surveyToDelete = surveyRepository.findById(id).orElseThrow();
        model.addAttribute("survey", surveyToDelete);
        return "deleteSurvey";
    }

    @PostMapping("/deleteSurvey/{id}")
    @Transactional 
    public String deleteSurvey(@PathVariable("id") Long id) {

        List<Answer> answers = answerRepository.findByQuestionId(id);
        List<Question> questions = questionRepository.findBySurveyId(id);

        answerRepository.deleteAll(answers);
        questionRepository.deleteAll(questions);
        surveyRepository.deleteById(id);
        return "redirect:/surveyList";
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/surveyList";
    }

    @PostMapping("/deleteQuestion/{surveyId}/{questionId}")
    @Transactional
    public String deleteQuestion(@PathVariable("surveyId") Long surveyId, @PathVariable("questionId") Long questionId) {
        answerRepository.deleteAll(answerRepository.findByQuestionId(questionId));
        questionRepository.deleteById(questionId);
        return "redirect:/editSurvey/" + surveyId;
    }

    

}
