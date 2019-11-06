/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.config;

/**
 *
 * @author vivien saa
 */
public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    public static final String SIGNING_KEY = "2018cam~lock0205^dfrk25D25KL3458makeJDFndo.vfvhs";
    public static final String TOKEN_PREFIX = "CAMLOCALBEARER ";
    public static final String HEADER_STRING = "Authorization";
    public static final String ROLE_AGENT = "ROLE_AGENT";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_CLIENT = "ROLE_CLIENT";
    public static final String ROLE_REFRESH_TOKEN = "ROLE_REFRESH_TOKEN";
    public static final String DEFAULT_ADMIN_USERNAME = "admin@admin.com";
    public static final String DEFAULT_ADMIN_NAME = "admin";
    public static final String DEFAULT_ADMIN_PASSWORD = "admin";
    public static final String ISSUER = "http://localhost:8080/api/";

}
