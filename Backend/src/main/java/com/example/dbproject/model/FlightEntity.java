package com.example.dbproject.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "flight", schema = "public", catalog = "db_phase3")
public class FlightEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "flightnumber")
  private int flightnumber;
  @Basic
  @Column(name = "date")
  private Date date;
  @Basic
  @Column(name = "airlineid")
  private int airlineid;

  public int getFlightnumber() {
    return flightnumber;
  }

  public void setFlightnumber(int flightnumber) {
    this.flightnumber = flightnumber;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
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

    FlightEntity that = (FlightEntity) o;

    if (flightnumber != that.flightnumber) {
      return false;
    }
    if (airlineid != that.airlineid) {
      return false;
    }
    if (date != null ? !date.equals(that.date) : that.date != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = flightnumber;
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + airlineid;
    return result;
  }
}
