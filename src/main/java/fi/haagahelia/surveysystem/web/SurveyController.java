package fi.haagahelia.surveysystem.web;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.surveysystem.domain.Survey;
import fi.haagahelia.surveysystem.domain.SurveyRepository;

@Controller
public class SurveyController {

    private final SurveyRepository surveyRepository;

    SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @GetMapping("/createSurvey")
    public String createSurvey() {
        return "createSurvey";
    }

    @GetMapping("/survey/{id}")
    public String survey(@PathVariable Long id, Model model) {

        Survey survey1 = surveyRepository.findById(id).orElseThrow();

        model.addAttribute("survey", survey1);
        return "survey";
    }

    @PostMapping("/saveSurvey")
    public String saveSurvey(Survey survey) {
        Survey savedSurvey = surveyRepository.save(survey);
        return "redirect:/survey/" + savedSurvey.getId();
    }

    @GetMapping("/surveyList")
    public String surveyList(Model model) {
        model.addAttribute("Surveys", surveyRepository.findAll());
        return "surveyList";
    }

}
