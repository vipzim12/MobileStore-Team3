package com.team3.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id_category")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "id_group_categoty")
  private int idGroup;
  @Column(name = "name")
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdGroup() {
    return idGroup;
  }

  public void setIdGroup(int idGroup) {
    this.idGroup = idGroup;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}
