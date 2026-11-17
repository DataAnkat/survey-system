package fi.haagahelia.surveysystem.domain;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
    
    List<Survey> findByName(String name);
    List<Survey> findAll();
}

