package com.team3.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
  @Id
  @Column(name = "id_order")
  private int id;
  @Column(name = "id_order_detail")
  private int idOrderDetail;
  @Column(name = "status")
  private String status;

  @OneToOne
  @JoinColumn(name = "id_user")
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdOrderDetail() {
    return idOrderDetail;
  }

  public void setIdOrderDetail(int idOrderDetail) {
    this.idOrderDetail = idOrderDetail;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }



}
