/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.entities;

/**
 *
 * @author vivien saa
 */
public class AuthToken {

    private String token;
    private String username;

    public AuthToken() {

    }

    public AuthToken(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
