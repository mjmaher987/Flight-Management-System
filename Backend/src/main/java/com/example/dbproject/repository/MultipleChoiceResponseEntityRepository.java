package com.example.dbproject.repository;

import com.example.dbproject.model.MultipleChoiceResponseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleChoiceResponseEntityRepository
    extends JpaRepository<MultipleChoiceResponseEntity, Integer> {

  List<MultipleChoiceResponseEntity> findAllBySurveyid(int surveyid);
}
