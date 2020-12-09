/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.service.PemasokService;
import com.project.inventory.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author i am me
 */
@Controller
public class DashboardController {
    @Autowired
    ProdukService produkService;
    
    @Autowired
    PemasokService pemasokService;
    
    @GetMapping("/dashboard")
    public String getDashboard(){
        
        return "dashboard/index";
    }
}
