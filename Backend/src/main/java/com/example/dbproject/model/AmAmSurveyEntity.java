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
@Table(name = "am_am_survey", schema = "public", catalog = "db_phase3")
@IdClass(AmAmSurveyEntityPK.class)
public class AmAmSurveyEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "airlinemanager2")
  private String airlinemanager2;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "surveyid")
  private int surveyid;
  @Basic
  @Column(name = "airlinemanager1")
  private String airlinemanager1;

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

  public String getAirlinemanager1() {
    return airlinemanager1;
  }

  public void setAirlinemanager1(String airlinemanager1) {
    this.airlinemanager1 = airlinemanager1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AmAmSurveyEntity that = (AmAmSurveyEntity) o;

    if (surveyid != that.surveyid) {
      return false;
    }
    if (airlinemanager2 != null ? !airlinemanager2.equals(that.airlinemanager2)
        : that.airlinemanager2 != null) {
      return false;
    }
    if (airlinemanager1 != null ? !airlinemanager1.equals(that.airlinemanager1)
        : that.airlinemanager1 != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = airlinemanager2 != null ? airlinemanager2.hashCode() : 0;
    result = 31 * result + surveyid;
    result = 31 * result + (airlinemanager1 != null ? airlinemanager1.hashCode() : 0);
    return result;
  }
}
