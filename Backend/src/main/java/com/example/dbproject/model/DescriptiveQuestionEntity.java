package com.example.dbproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "descriptive_question", schema = "public", catalog = "db_phase3")
@IdClass(DescriptiveQuestionEntityPK.class)
public class DescriptiveQuestionEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "qnumber")
  private int qnumber;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "surveyid")
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

    DescriptiveQuestionEntity that = (DescriptiveQuestionEntity) o;

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
