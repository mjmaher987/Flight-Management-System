package com.example.dbproject.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
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
@Table(name = "descriptive_response", schema = "public", catalog = "db_phase3")
public class DescriptiveResponseEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private int id;

  @Basic
  @Column(name = "responsetime")
  private Timestamp responsetime;

  @Basic
  @Column(name = "qnumber")
  private Integer qnumber;

  @Basic
  @Column(name = "surveyid")
  private int surveyid;

  @Basic
  @Column(name = "answer")
  private String answer;

  @Basic
  @Column(name = "ticketnumber")
  private int ticketnumber;
}