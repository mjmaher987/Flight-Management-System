package com.example.dbproject.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "multiple_choice_question", schema = "public", catalog = "db_phase3")
@IdClass(MultipleChoiceQuestionEntityPK.class)
public class MultipleChoiceQuestionEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "qnumber")
  private int qnumber;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "surveyid")
  private int surveyid;
  @Basic
  @Column(name = "choice1")
  private String choice1;
  @Basic
  @Column(name = "choice2")
  private String choice2;
  @Basic
  @Column(name = "choice3")
  private String choice3;
  @Basic
  @Column(name = "choice4")
  private String choice4;

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

  public String getChoice1() {
    return choice1;
  }

  public void setChoice1(String choice1) {
    this.choice1 = choice1;
  }

  public String getChoice2() {
    return choice2;
  }

  public void setChoice2(String choice2) {
    this.choice2 = choice2;
  }

  public String getChoice3() {
    return choice3;
  }

  public void setChoice3(String choice3) {
    this.choice3 = choice3;
  }

  public String getChoice4() {
    return choice4;
  }

  public void setChoice4(String choice4) {
    this.choice4 = choice4;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MultipleChoiceQuestionEntity that = (MultipleChoiceQuestionEntity) o;

    if (qnumber != that.qnumber) {
      return false;
    }
    if (surveyid != that.surveyid) {
      return false;
    }
    if (choice1 != null ? !choice1.equals(that.choice1) : that.choice1 != null) {
      return false;
    }
    if (choice2 != null ? !choice2.equals(that.choice2) : that.choice2 != null) {
      return false;
    }
    if (choice3 != null ? !choice3.equals(that.choice3) : that.choice3 != null) {
      return false;
    }
    if (choice4 != null ? !choice4.equals(that.choice4) : that.choice4 != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = qnumber;
    result = 31 * result + surveyid;
    result = 31 * result + (choice1 != null ? choice1.hashCode() : 0);
    result = 31 * result + (choice2 != null ? choice2.hashCode() : 0);
    result = 31 * result + (choice3 != null ? choice3.hashCode() : 0);
    result = 31 * result + (choice4 != null ? choice4.hashCode() : 0);
    return result;
  }
}
