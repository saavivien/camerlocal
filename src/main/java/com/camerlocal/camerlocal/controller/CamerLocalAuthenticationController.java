/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.controller;

import com.camerlocal.camerlocal.config.JwtTokenUtil;
import com.camerlocal.camerlocal.entities.AuthToken;
import com.camerlocal.camerlocal.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vivien saa
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authenticate")
public class CamerLocalAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailService;

    @PostMapping
    public ResponseEntity<AuthToken> register(@RequestBody User loginUser) throws AuthenticationException {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        final UserDetails user = userDetailService.loadUserByUsername(loginUser.getEmail());
        final String token = jwtTokenUtil.generateToken(user);
        return new ResponseEntity<>(new AuthToken(token, user.getUsername()), HttpStatus.OK);
    }

}
