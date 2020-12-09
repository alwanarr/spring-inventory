/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Pemasok;
import com.project.inventory.service.PemasokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author i am me
 */
@Controller
public class SupplierController {
    
    @Autowired
    PemasokService pemasokService;
    
    
    
    @GetMapping("/admin/supplier")
    public String showSupplier(Model model){
        Iterable<Pemasok> getAll = pemasokService.getAllPemasok();
        model.addAttribute("pemasok", getAll);
        return "supplier/index";
    }
    
    @PostMapping("/admin/savepemasok")
    public String saveSupplier(@RequestParam("nama") String nama,
                               @RequestParam("no_hp") String no_hp,
                               @RequestParam("email") String email,
                               @RequestParam("alamat") String alamat,
                               RedirectAttributes atts
                               
                                ){
        System.out.println("alamat "+alamat);
        pemasokService.savePemasok(nama, no_hp, email, alamat);
        
        atts.addFlashAttribute("success", "success");
        
        
        return "redirect:/admin/supplier";
    }
    
    @GetMapping("/admin/supplier/{id}")
    @ResponseBody
    public Pemasok getOnePemasok(@PathVariable(value = "id") String id, Model model){
        Integer idku = Integer.parseInt(id);
        Pemasok pemasok = pemasokService.getOnePemasok(idku);
        
        return pemasok;
    }
    @PostMapping("/admin/updatepemasok")
    public String updatePemasok(
                                RedirectAttributes atts,
                                @RequestParam("nama") String nama,
                                @RequestParam("id") String id,
                                @RequestParam("no_hp") String no_hp,
                                @RequestParam("email") String email,
                                @RequestParam("alamat") String alamat
    ){
        Integer idku = Integer.parseInt(id);
        pemasokService.updatePemasok(idku, nama, email, no_hp, alamat);  
        
        return "redirect:/admin/supplier";
    }
    
    
    @GetMapping("/admin/supplier/delete/{id}")
    public String deleteRoom(@PathVariable(value = "id") int id){
        pemasokService.deleteById(id);
        return "redirect:/admin/supplier";
    }
}
