package fi.haagahelia.surveysystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.surveysystem.domain.Survey;
import fi.haagahelia.surveysystem.domain.SurveyRepository;

@SpringBootApplication
public class SurveysystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveysystemApplication.class, args);
	}

	@Bean 
	public CommandLineRunner initRepository(SurveyRepository surveyRepository) {
		return (args) -> {

			Survey survey1 = new Survey("Survey1", null, "Survey description");

			ArrayList<String> questions = new ArrayList<String>();

			questions.add("Mikä nimi on?");
			questions.add("Mikä on kello?");
			questions.add("Mikä on päivä?");

			survey1.setQuestions(questions);

			surveyRepository.save(survey1);

			Survey survey2 = new Survey("Survey2", null, "Survey description");

			questions = new ArrayList<String>();

			questions.add("Mikä lempielokuva?");
			questions.add("Missä?");
			questions.add("Mikä?");

			survey2.setQuestions(questions);

			surveyRepository.save(survey2);


			Survey survey3 = new Survey("Palautekysely", null,"Tämä kysely on kohdistettu Haaga-Helian opisikelijoille. Palautetta pyydetään opettajien toimintavoista kurssien aikana ja toivotaan, että opiskelijat ilmiantavat epäoikeudenmukaisen käytöksen, mikäli sellaista havaitaan. Palautteet kerätään, jotta voidaan ottaa tarpeenmukaiset toimenpiteet käyttöön opettajan toimintatapojen parantamiseksi.");

			questions = new ArrayList<String>();

			questions.add("Opettajan nimi");
			questions.add("Kurssitoteutus");
			questions.add("Kerro opettajan toimintatavoista kurssin aikana");
			questions.add("Jos kurssin aikana ilmeni epäoikeudenmukaista käytöstä, kirjaa se tähän.");

			survey3.setQuestions(questions);

			surveyRepository.save(survey3);
		};	
	}

}
