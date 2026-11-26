package fi.haagahelia.surveysystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.surveysystem.domain.Answer;
import fi.haagahelia.surveysystem.domain.AnswerRepository;
import fi.haagahelia.surveysystem.domain.Question;
import fi.haagahelia.surveysystem.domain.QuestionRepository;
import fi.haagahelia.surveysystem.domain.Survey;
import fi.haagahelia.surveysystem.domain.SurveyRepository;

@SpringBootApplication
public class SurveysystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveysystemApplication.class, args);
	}

	@Bean 
	public CommandLineRunner initRepository(SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
		return (args) -> {

			// kys 1
			Survey survey1 = new Survey("Testikysely", "Tähän tulee kyselyn kuvaus");

			Question question1 = new Question("Mikä nimesi on?", survey1, null);
			Question question1_2 = new Question("Mikä?", survey1, null);
			
			Answer answer1 = new Answer(question1, "Tero");
			Answer answer1_2 = new Answer(question1_2, "Niin, että Tero");
	

			surveyRepository.save(survey1);

			questionRepository.save(question1);
			questionRepository.save(question1_2);
			
			answerRepository.save(answer1);
			answerRepository.save(answer1_2);
		

			// kys 2
			Survey survey2 = new Survey("Lounasravintolan palautekysely", "Tällä kyselyllä selvitetään, että mitkä ruuat ovat erityisesti olleet opiskelijoiden mieleen ja millaisia ruokatoiveita heillä voisi olla.");
			Question question2_1 = new Question("Mikä päivä tänään on?", survey2, null);
			Question question2_2 = new Question("Mitä söit tänään?", survey2, null);
			Question question2_3 = new Question("Mitä pidit tämän päivän annoksestasi?", survey2, null);
			Question question2_4 = new Question("Millaista tai mitä ruokaa toivoisit meidän tarjoavan?", survey2, null);
 
			surveyRepository.save(survey2);
			questionRepository.save(question2_1);
			questionRepository.save(question2_2);
			questionRepository.save(question2_3);
			questionRepository.save(question2_4);

			Answer answer2_1 = new Answer("Torstai 19.11.2026");
			Answer answer2_2 = new Answer("Makaronilaatikko");
			Answer answer2_3 = new Answer("Oli hyvää, mutta hieman mauton. Ketsupin kanssa oli oikein maistuvaa silti.");
			Answer answer2_4 = new Answer("Jonain erikoispäivänä toivoisin pizzaa");

			answerRepository.save(answer2_1);
			answerRepository.save(answer2_2);
			answerRepository.save(answer2_3);
			answerRepository.save(answer2_4);

			// kys 3
			Survey survey3 = new Survey("Palautekysely", "Tämä kysely on kohdistettu Haaga-Helian opisikelijoille. Palautetta pyydetään opettajien toimintavoista kurssien aikana ja toivotaan, että opiskelijat ilmiantavat epäoikeudenmukaisen käytöksen, mikäli sellaista havaitaan. Palautteet kerätään, jotta voidaan ottaa tarpeenmukaiset toimenpiteet käyttöön opettajan toimintatapojen parantamiseksi.");
			
			Question question3_1 = new Question("Kenestä opettajasta on kyse?", survey3, null);
			Question question3_2 = new Question("Mikä kurssitoteutus on kyseessä? (Kirjaa myös kurssikoodi)", survey3, null);
			Question question3_3 = new Question("Millaisena koit kurssin?", survey3, null);
			Question question3_4 = new Question("Ilmenikö kurssin aikana epäoikeudenmukaista käytöstä opettajan toimesta? Jos kyllä, kirjaa vapaalla sanalla havaitsemastasi käytöksestä.", survey3, null);
			Question question3_5 = new Question("Miten haluaisit, että palautteesi kanssa edetään?", survey3, null);

			surveyRepository.save(survey3);
			questionRepository.save(question3_1);
			questionRepository.save(question3_2);
			questionRepository.save(question3_3);
			questionRepository.save(question3_4);
			questionRepository.save(question3_5);
		};	
	}

}
