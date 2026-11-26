package fi.haagahelia.surveysystem.domain;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

// ListCrudRepository returns List (instead of Iterable) from findAll, saveAll, etc.
public interface AnswerRepository extends ListCrudRepository<Answer, Long> {

    List<Answer> findByQuestion(Question question);
    // or, if you only have the id:
    List<Answer> findByQuestionId(Long questionId);
}
