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

/**
 *
 * @author i am me
 */
@Controller
public class OrderController {
    @Autowired
    ProdukService produkService;
    
    
    @GetMapping("/admin/order")
    public String showOrder(Model model){
        Iterable<Produk> p = produkService.getAllProduk();
        model.addAttribute("produk", p);
        return "order/order";
    }
    
    @GetMapping("/admin/checkout")
    public String showCheckoutPage(){
        return "order/checkout";
    }
}
