package com.example.dbproject.controller;

import com.example.dbproject.model.PassengerEntity;
import com.example.dbproject.model.SurveyResultModel;
import com.example.dbproject.repository.PassengerEntityRepository;
import com.example.dbproject.repository.QuestionEntityRepository;
import com.example.dbproject.repository.SurveyEntityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Passenger")
@CrossOrigin
@AllArgsConstructor
public class PassengerController {
  static String logined;
  static String response=
  private final ObjectMapper mapper;
  private PassengerEntityRepository passengerEntityRepository;
  private SurveyEntityRepository surveyEntityRepository;
  private QuestionEntityRepository questionEntityRepository;

  @GetMapping("/login/{id}/{passId}")
  public String getAllPassenger(@PathVariable String id, @PathVariable String passId) {
    Optional<PassengerEntity> passengerEntity =
        passengerEntityRepository.findByIdAndPassportnumber(
            Integer.parseInt(id), Integer.parseInt(passId));
    if (passengerEntity.isEmpty()) {
      return "fail..";
    }
    logined = id;

    return "welcome..";
  }

  @GetMapping("/get_active_des/{id}")
  public String getActiveDes(@PathVariable String id) throws JsonProcessingException {
    SurveyResultModel passenger = mapper.readValue(response, SurveyResultModel.class);
    if (!Objects.equals(logined, id)) return "you are not logined";
    return mapper.writeValueAsString(
        surveyEntityRepository.findSurveyByPassengerId(Long.valueOf(id)));
  }
}
