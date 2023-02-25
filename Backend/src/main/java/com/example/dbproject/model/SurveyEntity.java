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
@Table(name = "survey", schema = "public", catalog = "db_phase3")
public class SurveyEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private int id;

  @Basic
  @Column(name = "starttime")
  private Timestamp starttime;

  @Basic
  @Column(name = "endtime")
  private Timestamp endtime;

  @Basic
  @Column(name = "isvalid")
  private Boolean isvalid;

  @Basic
  @Column(name = "flightnumber")
  private int flightnumber;

  @Basic
  @Column(name = "creator")
  private String creator;
}
