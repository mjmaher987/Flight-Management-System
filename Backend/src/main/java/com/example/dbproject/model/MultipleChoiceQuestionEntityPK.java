package com.example.dbproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

public class MultipleChoiceQuestionEntityPK implements Serializable {

  @Column(name = "qnumber")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int qnumber;
  @Column(name = "surveyid")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int surveyid;

  public int getQnumber() {
    return qnumber;
  }

  public void setQnumber(int qnumber) {
    this.qnumber = qnumber;
  }

  public int getSurveyid() {
    return surveyid;
  }

  public void setSurveyid(int surveyid) {
    this.surveyid = surveyid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MultipleChoiceQuestionEntityPK that = (MultipleChoiceQuestionEntityPK) o;

    if (qnumber != that.qnumber) {
      return false;
    }
    if (surveyid != that.surveyid) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = qnumber;
    result = 31 * result + surveyid;
    return result;
  }
}
