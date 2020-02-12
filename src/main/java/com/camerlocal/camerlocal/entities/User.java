/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author vivien saa
 */
@Entity
@Table(name = "user_table")
@NamedQueries({
    @NamedQuery(name = "user_find_user_by_user_name", query = "SELECT u FROM User u WHERE u.email = :userName")
})
public class User extends CoreObject implements UserDetails {

    private String title;

    @Column(name = "first_name")
    private String firstName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String phone1;

    private String phone2;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image profileImage;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

//    @JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    private List<UserRole> listUserRoles;
    @JsonIgnore
    @OneToMany(mappedBy = "userCreator", fetch = FetchType.LAZY)
    private List<CoreObject> listCoreObjectCreateds;

    @JsonIgnore
    @OneToMany(mappedBy = "userArchivist", fetch = FetchType.LAZY)
    private List<CoreObject> listCoreObjectArchiveds;

    @JsonIgnore
    @OneToMany(mappedBy = "userCommentator", fetch = FetchType.LAZY)
    private List<Comment> listComments;

    @JsonIgnore
    @OneToMany(mappedBy = "userMarker", fetch = FetchType.LAZY)
    private List<Mark> listMarks;

    @JsonIgnore
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

    @Override
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

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

//    public List<UserRole> getListUserRoles() {
//        return listUserRoles;
//    }
//
//    public void setListUserRoles(List<UserRole> listUserRoles) {
//        this.listUserRoles = listUserRoles;
//    }
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        getRoles().forEach((Role role) -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return getIsActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
