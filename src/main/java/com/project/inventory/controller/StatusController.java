/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Status;
import com.project.inventory.repository.StatusRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author i am me
 */
@Controller
public class StatusController {
    @Autowired
    StatusRepository statusRepository;
    
    
    @GetMapping("/statuspage")
    public String getStatusPage(Model model){
        Status status = new Status();
        model.addAttribute("status", status);
        return "test/status";
    }
    

    @RequestMapping(value = "/status", method=RequestMethod.POST)
    public String  saveStatus(@Valid @ModelAttribute("status") Status status, Model model, BindingResult result){
//        ModelAndView mv = new ModelAndView();
//        Status s = new Status();
        System.out.println("binding "+result);
        System.out.println("status "+status);
//        statusRepository.save(status);
//        model.addAttribute("status", status);
        return "redirect:/www";
    }
}
