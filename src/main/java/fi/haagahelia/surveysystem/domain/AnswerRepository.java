package fi.haagahelia.surveysystem.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    List<Answer> findByQuestion(Question question);
    // or, if you only have the id:
    Answer findByQuestionId(Long questionId);
    
    List <Answer> findAll();
} 
