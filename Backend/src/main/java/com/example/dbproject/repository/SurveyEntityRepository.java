package com.example.dbproject.repository;

import com.example.dbproject.model.SurveyEntity;
import com.example.dbproject.model.SurveyResultModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SurveyEntityRepository extends JpaRepository<SurveyEntity, Integer> {
  List<SurveyEntity> findAllByCreator(String creator);

  List<SurveyEntity> findAllByCreatorAndId(String creator, Integer id);

  @Query(
      value =
          "select survey.id as surveyId, flight.flightnumber as flightNumber, multiple_choice_question.qnumber as qnumber,\n"
              + "question.questiontitle as question, choice1, choice2, choice3, choice4\n"
              + "from survey join flight on survey.flightnumber = flight.flightnumber join ticket on ticket.flightid = flight.flightnumber\n"
              + "join passenger on passenger.id = ticket.passengerid join multiple_choice_question on multiple_choice_question.surveyid = survey.id\n"
              + "join question on  question.surveyid = survey.id\n"
              + "where passenger.id = :passengerId \n"
              + "and survey.isvalid = 'true'",
      nativeQuery = true)
  List<SurveyResultModel> findSurveyByPassengerId(@Param("passengerId") Long passengerId);
}
