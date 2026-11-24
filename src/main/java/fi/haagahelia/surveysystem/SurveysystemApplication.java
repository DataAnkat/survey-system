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
			Survey survey1 = new Survey("Survey1", "Survey description");

			Question question1 = new Question("Mikä nimesi on?", survey1, null);
			Question question1_2 = new Question("Mikä?", survey1, null);
			
			Answer answer1 = new Answer(question1, "En tiiä mikä");
			Answer answer1_2 = new Answer(question1_2, "En mikään minkä tiedän");

			surveyRepository.save(survey1);

			questionRepository.save(question1);
			questionRepository.save(question1_2);
			
			answerRepository.save(answer1);
			answerRepository.save(answer1_2);

			// kys 2
			Survey survey2 = new Survey("Survey2", "Survey description");
			Question question2 = new Question("Mikä päivä on?", survey2, null);

			surveyRepository.save(survey2);
			questionRepository.save(question2);

			Answer answer2 = new Answer("En tiiä mikä mahtaa ollaaa");
			answerRepository.save(answer2);

			// kys 3
			Survey survey3 = new Survey("Palautekysely", "Tämä kysely on kohdistettu Haaga-Helian opisikelijoille. Palautetta pyydetään opettajien toimintavoista kurssien aikana ja toivotaan, että opiskelijat ilmiantavat epäoikeudenmukaisen käytöksen, mikäli sellaista havaitaan. Palautteet kerätään, jotta voidaan ottaa tarpeenmukaiset toimenpiteet käyttöön opettajan toimintatapojen parantamiseksi.");
			Question question3 = new Question("Onko tämä kolmas kysely?", survey3, null);

			surveyRepository.save(survey3);
			questionRepository.save(question3);
		};	
	}

}
