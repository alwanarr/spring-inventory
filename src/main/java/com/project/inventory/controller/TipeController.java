/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Tipe;
import com.project.inventory.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author i am me
 */
@Controller
public class TipeController {
    @Autowired
    TipeService tipeService;
    
    @PostMapping("/admin/savetipekategori")
    public String saveTypeCategory(@RequestParam("namaKategori") String nama, 
                                    @RequestParam("category") Integer kategori
            ){
        tipeService.saveTipe(nama, kategori);
        return "redirect:/admin/categories";
    }
    
    @GetMapping("/admin/getOneTipe/{id}")
    @ResponseBody
    public Tipe getOneTipe(@PathVariable(value = "id") Integer id){
        Tipe tipe = tipeService.getOneTipe(id);
        return tipe;
    }
    
    @GetMapping("/admin/tipecategory/delete/{id}")
    public String deleteTipeCategory(@PathVariable(value="id") Integer id){
        tipeService.deleteTipeCategory(id);
        return "redirect:/admin/categories";
    }
    
   
    @PostMapping("/admin/updatetipecategory")
    public String updateCategory(@RequestParam("nama") String nama,
            @RequestParam("id") Integer id,
            @RequestParam("category") Integer category
            ) {
       
        tipeService.updateTipeCategory(id, nama, category);
        return "redirect:/admin/categories";
    }
}
