package com.example.dbproject.repository;

import com.example.dbproject.model.DescriptiveResponseEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptiveResponseEntityRepository
    extends JpaRepository<DescriptiveResponseEntity, Integer> {
  List<DescriptiveResponseEntity> findAllBySurveyid(int surveyid);
}
