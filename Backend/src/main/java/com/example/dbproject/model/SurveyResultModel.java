package com.example.dbproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResultModel {
  private Integer surveyId;
  private Integer flightNumber;
  private Integer qnumber;
  private String question;
  private String choice1;
  private String choice2;
  private String choice3;
  private String choice4;
}
