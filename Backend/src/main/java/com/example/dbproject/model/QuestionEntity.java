package com.example.dbproject.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question", schema = "public", catalog = "db_phase3")
@IdClass(QuestionEntityPK.class)
public class QuestionEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "qnumber")
  private Integer qnumber;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "surveyid")
  private int surveyid;

  @Basic
  @Column(name = "questiontitle")
  private String questiontitle;

  @Basic
  @Column(name = "access")
  private Boolean access;

  @Basic
  @Column(name = "forecetoanswer")
  private Boolean forecetoanswer;

  @Basic
  @Column(name = "passenger_type")
  private String passengerType;
}
