package com.example.dbproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

public class QuestionEntityPK implements Serializable {

  @Column(name = "qnumber")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int qnumber;
  @Column(name = "surveyid")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int surveyid;

}
