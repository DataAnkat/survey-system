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
    //Luodaan survey
    @GetMapping("/createSurvey")
    public String createSurvey() {
        return "createSurvey";
    }

    //Haetaan survey id:n mukaan
    @GetMapping("/survey/{id}")
    public String survey(@PathVariable Long id, Model model) {

        Survey survey1 = surveyRepository.findById(id).orElseThrow();

        model.addAttribute("survey", survey1);
        return "survey";
    }

    //Tallennetaan survey
    @PostMapping("/saveSurvey")
    public String saveSurvey(Survey survey) {
        Survey savedSurvey = surveyRepository.save(survey);
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
        model.addAttribute("survey", surveyToEdit);
        return "editSurvey"; 
    }

    @GetMapping("/deleteSurvey/{id}")
    public String confirmDelete(@PathVariable("id") Long id, Model model) {
        Survey surveyToDelete = surveyRepository.findById(id).orElseThrow();
        model.addAttribute("survey", surveyToDelete);
        return "deleteSurvey";
    }

    @PostMapping("/deleteSurvey/{id}")
    public String deleteSurvey(@PathVariable("id") Long id) {
        surveyRepository.deleteById(id);
        return "redirect:/surveyList";
    }

}
