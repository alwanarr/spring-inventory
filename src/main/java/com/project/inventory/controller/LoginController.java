/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author i am me
 */
@Controller
public class LoginController {
    
    
    @GetMapping("/login")
    public String getFormLogin(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        
        if(login != "anonymousUser"){
            return "redirect:/logout";
        }
   
        return "login/login";
    }
    
    @GetMapping("/kepalagudang")
    public String getPage(){
        return "test/test";
    }
}
