package com.example.dbproject.repository;

import com.example.dbproject.model.QuestionEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionEntityRepository extends JpaRepository<QuestionEntity, Integer> {
  List<QuestionEntity> findAllBySurveyid(int surveyid);

  Optional<QuestionEntity> findAllBySurveyidAndQnumber(int surveyid, int qnumber);
}
