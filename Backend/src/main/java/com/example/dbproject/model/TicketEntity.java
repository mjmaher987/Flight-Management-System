package com.example.dbproject.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket", schema = "public", catalog = "db_phase3")
public class TicketEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "ticketnumber")
  private int ticketnumber;
  @Basic
  @Column(name = "type")
  private String type;
  @Basic
  @Column(name = "cost")
  private Integer cost;
  @Basic
  @Column(name = "seatnumber")
  private Integer seatnumber;
  @Basic
  @Column(name = "flightid")
  private int flightid;
  @Basic
  @Column(name = "passengerid")
  private int passengerid;

  public int getTicketnumber() {
    return ticketnumber;
  }

  public void setTicketnumber(int ticketnumber) {
    this.ticketnumber = ticketnumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public Integer getSeatnumber() {
    return seatnumber;
  }

  public void setSeatnumber(Integer seatnumber) {
    this.seatnumber = seatnumber;
  }

  public int getFlightid() {
    return flightid;
  }

  public void setFlightid(int flightid) {
    this.flightid = flightid;
  }

  public int getPassengerid() {
    return passengerid;
  }

  public void setPassengerid(int passengerid) {
    this.passengerid = passengerid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TicketEntity that = (TicketEntity) o;

    if (ticketnumber != that.ticketnumber) {
      return false;
    }
    if (flightid != that.flightid) {
      return false;
    }
    if (passengerid != that.passengerid) {
      return false;
    }
    if (type != null ? !type.equals(that.type) : that.type != null) {
      return false;
    }
    if (cost != null ? !cost.equals(that.cost) : that.cost != null) {
      return false;
    }
    if (seatnumber != null ? !seatnumber.equals(that.seatnumber) : that.seatnumber != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = ticketnumber;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (cost != null ? cost.hashCode() : 0);
    result = 31 * result + (seatnumber != null ? seatnumber.hashCode() : 0);
    result = 31 * result + flightid;
    result = 31 * result + passengerid;
    return result;
  }
}
