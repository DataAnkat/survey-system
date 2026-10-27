package fi.haagahelia.surveysystem.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import fi.haagahelia.surveysystem.domain.Survey;
import fi.haagahelia.surveysystem.domain.SurveyRepository;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class SurveyController {

    private final SurveyRepository surveyRepository;

    SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

     @RequestMapping("/createSurvey")
    public String surveyString() {
    //model.addAttribute("Survey", new Survey("jotain",null));
        return "createSurvey";
    }
    @RequestMapping ("/surveyList")
    public String survey(Model model) {
        model.addAttribute("Surveys", surveyRepository.findAll());
        return "surveyList";
    }
    
}
