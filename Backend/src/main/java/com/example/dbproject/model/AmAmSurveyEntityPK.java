package com.example.dbproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

public class AmAmSurveyEntityPK implements Serializable {

  @Column(name = "airlinemanager2")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String airlinemanager2;
  @Column(name = "surveyid")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int surveyid;

  public String getAirlinemanager2() {
    return airlinemanager2;
  }

  public void setAirlinemanager2(String airlinemanager2) {
    this.airlinemanager2 = airlinemanager2;
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

    AmAmSurveyEntityPK that = (AmAmSurveyEntityPK) o;

    if (surveyid != that.surveyid) {
      return false;
    }
    if (airlinemanager2 != null ? !airlinemanager2.equals(that.airlinemanager2)
        : that.airlinemanager2 != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = airlinemanager2 != null ? airlinemanager2.hashCode() : 0;
    result = 31 * result + surveyid;
    return result;
  }
}
