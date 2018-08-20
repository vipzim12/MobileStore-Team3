package com.team3.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role-User")
public class RoleUser implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id_user")
  private int userId;
  @Id
  @Column(name = "role_id ")
  private int roleId;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

}
