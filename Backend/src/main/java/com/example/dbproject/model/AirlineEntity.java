package com.example.dbproject.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airline", schema = "public", catalog = "db_phase3")
public class AirlineEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private int id;
  @Basic
  @Column(name = "name")
  private String name;
  @Basic
  @Column(name = "airlinemanagerid")
  private String airlinemanagerid;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAirlinemanagerid() {
    return airlinemanagerid;
  }

  public void setAirlinemanagerid(String airlinemanagerid) {
    this.airlinemanagerid = airlinemanagerid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AirlineEntity that = (AirlineEntity) o;

    if (id != that.id) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (airlinemanagerid != null ? !airlinemanagerid.equals(that.airlinemanagerid)
        : that.airlinemanagerid != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (airlinemanagerid != null ? airlinemanagerid.hashCode() : 0);
    return result;
  }
}
