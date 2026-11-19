package fi.haagahelia.surveysystem.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    List<Answer> findByQuestion(Survey survey);
    // or, if you only have the id:
    List<Answer> findByQuestionId(Long surveyId);
    
} 
