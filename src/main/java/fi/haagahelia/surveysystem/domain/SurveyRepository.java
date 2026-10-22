package fi.haagahelia.surveysystem.domain;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
    
}

