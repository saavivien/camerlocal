/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author vivien saa
 */
public class CamerLocalRestController {

    protected final String BAD_REQUEST_MESSAGE = "your request might not be good, check and if needed contact the help support on +237697435439";
    protected final String INTERNAL_SERVER_ERROR_MESSAGE = "your request might not be good, check and if needed contact the help support on +237697435439";

    protected User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
