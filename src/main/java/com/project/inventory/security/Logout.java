/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 *
 * @author i am me
 */
public class Logout implements LogoutHandler{

    @Override
    public void logout(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) {
         System.out.println("logout");
    }
    
}