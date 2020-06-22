/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import com.camerlocal.camerlocal.config.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author vivien saa
 */
@Entity
@Table(name = "role_table")
@NamedQueries({
    @NamedQuery(name = "role_find_role_by_role_name", query = "SELECT r FROM Role r WHERE r.roleName = :roleName")})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true, name = "role_name")
    private String roleName;

    @Transient
    private String displayedName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
//    @JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<UserRole> listUserRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

//    public List<UserRole> getListUserRole() {
//        return listUserRole;
//    }
//
//    public void setListUserRole(List<UserRole> listUserRole) {
//        this.listUserRole = listUserRole;
//    }
    public String getDisplayedName() {
        this.displayedName = null;
        switch (getRoleName()) {
            case Constants.ROLE_ADMIN:
                this.displayedName = "Adminitrator";
                break;
            case Constants.ROLE_AGENT:
                this.displayedName = "Standard User";
                break;
            case Constants.ROLE_CLIENT:
                this.displayedName = "Client";
                break;
            default:
                break;
        }
        return this.displayedName;
    }

    public void setDisplaydName(String DisplaydName) {
        this.displayedName = DisplaydName;
    }

}
