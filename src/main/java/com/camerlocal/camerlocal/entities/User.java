/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class User extends CoreObject {

    private String title;

    @Column(name = "first_name")
    private String firstName;

    private String password;

    private String phone1;

    private String phone2;

    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRole> listUserRoles;

    @OneToMany(mappedBy = "userCreator", fetch = FetchType.LAZY)
    private List<CoreObject> listCoreObjectCreateds;

    @OneToMany(mappedBy = "userArchivist", fetch = FetchType.LAZY)
    private List<CoreObject> listCoreObjectArchiveds;

    @OneToMany(mappedBy = "userEditor", fetch = FetchType.LAZY)
    private List<CoreObjectEdition> listCoreObjectEditions;

    @OneToMany(mappedBy = "userCommentator", fetch = FetchType.LAZY)
    private List<Comment> listComments;

    @OneToMany(mappedBy = "userMarker", fetch = FetchType.LAZY)
    private List<Mark> listMarks;

    @OneToMany(mappedBy = "basketOwner", fetch = FetchType.LAZY)
    private List<Basket> listBaskets;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRole> getListUserRoles() {
        return listUserRoles;
    }

    public void setListUserRoles(List<UserRole> listUserRoles) {
        this.listUserRoles = listUserRoles;
    }

    public List<CoreObject> getListCoreObjectCreateds() {
        return listCoreObjectCreateds;
    }

    public void setListCoreObjectCreateds(List<CoreObject> listCoreObjectCreateds) {
        this.listCoreObjectCreateds = listCoreObjectCreateds;
    }

    public List<CoreObject> getListCoreObjectArchiveds() {
        return listCoreObjectArchiveds;
    }

    public void setListCoreObjectArchiveds(List<CoreObject> listCoreObjectArchiveds) {
        this.listCoreObjectArchiveds = listCoreObjectArchiveds;
    }

    @Override
    public List<CoreObjectEdition> getListCoreObjectEditions() {
        return listCoreObjectEditions;
    }

    @Override
    public void setListCoreObjectEditions(List<CoreObjectEdition> listCoreObjectEditions) {
        this.listCoreObjectEditions = listCoreObjectEditions;
    }

    public List<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(List<Comment> listComments) {
        this.listComments = listComments;
    }

    public List<Mark> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Mark> listMarks) {
        this.listMarks = listMarks;
    }

    public List<Basket> getListBaskets() {
        return listBaskets;
    }

    public void setListBaskets(List<Basket> listBaskets) {
        this.listBaskets = listBaskets;
    }

}
