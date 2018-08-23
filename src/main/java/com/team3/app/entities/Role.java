package com.team3.app.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int roleId;
  @Column(name = "name")
  private String roleName;
//  @ManyToMany(mappedBy = "roles")
//  private Set<User> users;

  public int getRoleId() {
    return roleId;
  }

//  public Set<User> getUsers() {
//    return users;
//  }
//
//  public void setUsers(Set<User> users) {
//    this.users = users;
//  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}
