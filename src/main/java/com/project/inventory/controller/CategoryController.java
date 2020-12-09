/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Kategori;
import com.project.inventory.entity.Tipe;
import com.project.inventory.service.KategoriService;
import com.project.inventory.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author i am me
 */
@Controller
public class CategoryController {

    @Autowired
    KategoriService kategoriService;
    
    @Autowired
    TipeService tipeService;

    @GetMapping("/admin/categories")
    public String showCategories(Model model) {
        Iterable<Kategori> k = kategoriService.getAllKategori();
        
        //tipe
        Iterable<Tipe> tipe = tipeService.getAllTipe();
        model.addAttribute("tipe", tipe);
        
        model.addAttribute("kategori", k);
        return "category/kategori";
    }

    @GetMapping("/admin/kategori-add")
    public String showKategori() {
        return "category/add-categories";
    }

    @PostMapping("/admin/savecategory")
    public String saveKategori(@RequestParam("namaKategori") String namaKategori,
            RedirectAttributes atts
            
    ) {
        kategoriService.save(namaKategori);
      
        atts.addFlashAttribute("success", "success");
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/category/{id}")
    @ResponseBody
    public Kategori getOneCategory(@PathVariable(value = "id") String id, Model model) {

        Integer idku = Integer.parseInt(id);
        Kategori k = kategoriService.getOneCategory(idku);
        

        return k;
    }

    @PostMapping("/admin/updatecategory")
    public String updateCategory(@RequestParam("nama") String nama,
            @RequestParam("id") Integer id) {
        
        kategoriService.updateCategory(id, nama);
        return "redirect:/admin/categories";
    }
    
    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable(value = "id") Integer id){
        
        kategoriService.deletCategory(id);
        return "redirect:/admin/categories";
    }
    
    
}
