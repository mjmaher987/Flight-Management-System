package com.example.dbproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport_airline", schema = "public", catalog = "db_phase3")
@IdClass(AirportAirlineEntityPK.class)
public class AirportAirlineEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "airportid")
  private int airportid;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "airlineid")
  private int airlineid;

  public int getAirportid() {
    return airportid;
  }

  public void setAirportid(int airportid) {
    this.airportid = airportid;
  }

  public int getAirlineid() {
    return airlineid;
  }

  public void setAirlineid(int airlineid) {
    this.airlineid = airlineid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AirportAirlineEntity that = (AirportAirlineEntity) o;

    if (airportid != that.airportid) {
      return false;
    }
    if (airlineid != that.airlineid) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = airportid;
    result = 31 * result + airlineid;
    return result;
  }
}
