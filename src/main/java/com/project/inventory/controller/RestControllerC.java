/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Tipe;
import com.project.inventory.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author i am me
 */
@RestController
public class RestControllerC {
//    @Autowired
//    TipeService tipeService;
//    
//    
//    @GetMapping("/admin/getOneTipe/{id}")
//    @ResponseBody
//    public Tipe getOneTipe(@PathVariable(value = "id") Integer id){
//        Tipe tipe = tipeService.getOneTipe(id);
//        return tipe;
//    }
}
