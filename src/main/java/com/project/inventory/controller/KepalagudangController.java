/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Produk;
import com.project.inventory.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author i am me
 */
@Controller
public class KepalagudangController {
    @Autowired
    ProdukService produkService;
    
    
    @GetMapping("/kepalagudang/product/{id}")
    public String acceptProduct(@PathVariable Integer id, 
            @RequestParam String status,
            RedirectAttributes atts,
            Model model){
        produkService.acceptProduct(id, status);
        atts.addFlashAttribute("success", "Produk Berhasil Di setujui");
        return "redirect:/products";
    }
    
    @GetMapping("/kepalagudang/product/reject/{id}")
    public String rejectProduct(@PathVariable Integer id, 
            @RequestParam String status,
            RedirectAttributes atts,
            Model model){
        produkService.rejectProduct(id, status);
        atts.addFlashAttribute("success", "Produk Berhasil Di tolak");
        return "redirect:/products";
    }
}
