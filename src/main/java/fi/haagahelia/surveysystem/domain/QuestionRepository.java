package fi.haagahelia.surveysystem.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findBySurvey(Survey survey);
    // or, if you only have the id:
    List<Question> findBySurveyId(Long surveyId);
}
