/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author i am me
 */
@Controller
public class TestController {
    @GetMapping("/test")
    public String showTest(){
        return "test/test";
    }
}
