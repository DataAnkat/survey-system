package fi.haagahelia.surveysystem.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.surveysystem.domain.SurveyRepository;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class SurveyController {
     @RequestMapping("/createSurvey")
    public String surveyString(Model model) {
    model.addAttribute("Survey", new Survey());
        return "createSurvey";
    }
    @RequestMapping ("/survey")
    public String survey(Model model) {
        model.addAttribute("Survey", SurveyRepository.findAll());
        return "survey";
    }
    
}
