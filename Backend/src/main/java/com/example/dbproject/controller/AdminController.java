package com.example.dbproject.controller;

import com.example.dbproject.model.DescriptiveResponseEntity;
import com.example.dbproject.model.MultipleChoiceResponseEntity;
import com.example.dbproject.model.PassengerEntity;
import com.example.dbproject.model.QuestionEntity;
import com.example.dbproject.model.SurveyEntity;
import com.example.dbproject.repository.DescriptiveResponseEntityRepository;
import com.example.dbproject.repository.PassengerEntityRepository;
import com.example.dbproject.repository.QuestionEntityRepository;
import com.example.dbproject.repository.SurveyEntityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
@CrossOrigin
@AllArgsConstructor
public class AdminController {
  private final ObjectMapper mapper;
  private PassengerEntityRepository passengerEntityRepository;
  private SurveyEntityRepository surveyEntityRepository;
  private QuestionEntityRepository questionEntityRepository;
  private DescriptiveResponseEntityRepository descriptiveResponseEntityRepository;
  private com.example.dbproject.repository.MultipleChoiceResponseEntityRepository
      MultipleChoiceResponseEntityRepository;

  @GetMapping("/get_passenger")
  public List<PassengerEntity> getAllPassenger() {
    return passengerEntityRepository.findAll();
  }

  @PostMapping("/add_passenger")
  public String addPassenger(@RequestBody String json) throws JsonProcessingException {
    PassengerEntity passenger = mapper.readValue(json, PassengerEntity.class);
    PassengerEntity entity =
        PassengerEntity.builder()
            .gender(passenger.getGender())
            .name(passenger.getName())
            .passportnumber(passenger.getPassportnumber())
            .build();
    passengerEntityRepository.save(entity);
    return String.format(
        "Passenger with name: '%s' ,passport number: '%s' added successfully",
        passenger.getName(), passenger.getPassportnumber());
  }

  @PostMapping("/update_passenger")
  public String updatePassenger(@RequestBody String json) throws JsonProcessingException {
    PassengerEntity passenger = mapper.readValue(json, PassengerEntity.class);
    Optional<PassengerEntity> passengerEntity =
        passengerEntityRepository.findById(passenger.getId());
    if (passengerEntity.isEmpty())
      return String.format("The passenger with ID %s was not found", passenger.getId());

    PassengerEntity entity = passengerEntity.get();
    entity.setName(passenger.getName());
    entity.setGender(passenger.getGender());
    entity.setPassportnumber(passenger.getPassportnumber());

    passengerEntityRepository.save(entity);
    return String.format(
        "Passenger with name: '%s' ,passport number: '%s' updated successfully",
        passenger.getName(), passenger.getPassportnumber());
  }

  @PostMapping("/delete_passenger")
  public String deletePassenger(@RequestParam Integer id) {

    Optional<PassengerEntity> passengerEntity = passengerEntityRepository.findById(id);
    if (passengerEntity.isEmpty())
      return String.format("The passenger with ID %s was not found", id);
    PassengerEntity entity = passengerEntity.get();
    passengerEntityRepository.delete(entity);
    return String.format(
        "Passenger with name: '%s' ,passport number: '%s' deleted successfully",
        entity.getName(), entity.getPassportnumber());
  }

  @GetMapping("/get_survey/{username}")
  public List<SurveyEntity> getAllSurvey(@PathVariable String username) {
    return surveyEntityRepository.findAllByCreator(username);
  }

  @PostMapping("/add_survey/{username}")
  public String addSurvey(@RequestBody String json, @PathVariable String username)
      throws JsonProcessingException {
    SurveyEntity survey = mapper.readValue(json, SurveyEntity.class);
    SurveyEntity entity =
        SurveyEntity.builder()
            .starttime(survey.getStarttime())
            .endtime(survey.getEndtime())
            .flightnumber(survey.getFlightnumber())
            .isvalid(survey.getIsvalid())
            .creator(username)
            .build();
    entity = surveyEntityRepository.save(entity);
    return String.format(
        "Survey with id: '%s' creator: '%s' added successfully", entity.getId(), username);
  }

  @PostMapping("/get_survey_question/{username}/{surveyId}")
  public String getSurveyQuestion(@PathVariable String username, @PathVariable Integer surveyId)
      throws JsonProcessingException {
    List<SurveyEntity> surveys = surveyEntityRepository.findAllByCreator(username);
    boolean isAdmin = false;
    for (SurveyEntity survey : surveys) {
      if (survey.getCreator().equals(username) && survey.getId() == surveyId) {
        isAdmin = true;
        break;
      }
    }
    if (!isAdmin) return "You are not the administrator of this survey";

    return mapper.writeValueAsString(questionEntityRepository.findAllBySurveyid(surveyId));
  }

  @PostMapping("/add_question/{username}")
  public String addQuestion(@RequestBody String json, @PathVariable String username)
      throws JsonProcessingException {
    QuestionEntity question = mapper.readValue(json, QuestionEntity.class);
    List<SurveyEntity> surveyEntities =
        surveyEntityRepository.findAllByCreatorAndId(username, question.getSurveyid());
    if (surveyEntities.size() == 0) return "You are not the administrator of this survey";

    QuestionEntity entity =
        QuestionEntity.builder()
            .questiontitle(question.getQuestiontitle())
            .access(question.getAccess())
            .forecetoanswer(question.getForecetoanswer())
            .passengerType(question.getPassengerType())
            .build();
    entity = questionEntityRepository.save(entity);
    return String.format(
        "Survey with question number: '%s' creator: '%s' added successfully",
        entity.getQnumber(), username);
  }

  @PostMapping("/update_question/{username}")
  public String updateQuestion(@RequestBody String json, @PathVariable String username)
      throws JsonProcessingException {
    QuestionEntity question = mapper.readValue(json, QuestionEntity.class);
    List<SurveyEntity> surveyEntities =
        surveyEntityRepository.findAllByCreatorAndId(username, question.getSurveyid());
    if (surveyEntities.size() == 0) return "You are not the administrator of this survey";

    Optional<QuestionEntity> entity =
        questionEntityRepository.findAllBySurveyidAndQnumber(
            question.getSurveyid(), question.getQnumber());

    if (entity.isEmpty()) return "not found";
    QuestionEntity entity1 = entity.get();
    entity1.setAccess(question.getAccess());
    entity1.setQuestiontitle(question.getQuestiontitle());
    entity1.setForecetoanswer(question.getForecetoanswer());
    entity1 = questionEntityRepository.save(entity1);
    return String.format("Question with qnumber: '%s' updated successfully", entity1.getQnumber());
  }

  @PostMapping("/delete_question/{username}/{surveyId}/{qnumber}")
  public String updateQuestion(
      @PathVariable String username,
      @PathVariable Integer surveyId,
      @PathVariable Integer qnumber) {
    List<SurveyEntity> surveyEntities =
        surveyEntityRepository.findAllByCreatorAndId(username, surveyId);
    if (surveyEntities.size() == 0) return "You are not the administrator of this survey";

    Optional<QuestionEntity> entity =
        questionEntityRepository.findAllBySurveyidAndQnumber(surveyId, qnumber);

    if (entity.isEmpty()) return "not found";
    QuestionEntity entity1 = entity.get();
    questionEntityRepository.delete(entity1);
    return String.format("Question with Qnumber: '%s' deleted successfully", qnumber);
  }

  @GetMapping("/get_response_des/{username}")
  public ArrayList<DescriptiveResponseEntity> getDescriptionResponse(
      @PathVariable String username) {
    List<SurveyEntity> surveyEntities = surveyEntityRepository.findAllByCreator(username);
    ArrayList<DescriptiveResponseEntity> response = new ArrayList<>();
    for (int i = 0; i < surveyEntities.size(); i++) {
      List<DescriptiveResponseEntity> descriptiveResponseEntities =
          descriptiveResponseEntityRepository.findAllBySurveyid(surveyEntities.get(i).getId());
      response.addAll(descriptiveResponseEntities);
    }
    return response;
  }

  @GetMapping("/get_response_choice/{username}")
  public ArrayList<MultipleChoiceResponseEntity> getChoiceResponse(@PathVariable String username) {
    List<SurveyEntity> surveyEntities = surveyEntityRepository.findAllByCreator(username);
    ArrayList<MultipleChoiceResponseEntity> response = new ArrayList<>();
    for (int i = 0; i < surveyEntities.size(); i++) {
      List<MultipleChoiceResponseEntity> descriptiveResponseEntities =
          MultipleChoiceResponseEntityRepository.findAllBySurveyid(surveyEntities.get(i).getId());
      response.addAll(descriptiveResponseEntities);
    }
    return response;
  }
}
