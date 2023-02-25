package com.example.dbproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

public class AirportAirlineEntityPK implements Serializable {

  @Column(name = "airportid")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int airportid;
  @Column(name = "airlineid")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    AirportAirlineEntityPK that = (AirportAirlineEntityPK) o;

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
