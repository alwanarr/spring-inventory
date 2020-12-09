/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Kategori;
import com.project.inventory.entity.Pemasok;
import com.project.inventory.entity.Produk;
import com.project.inventory.service.KategoriService;
import com.project.inventory.service.PemasokService;
import com.project.inventory.service.ProdukService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author i am me
 */
@Controller
public class ProductController {

    @Autowired
    KategoriService kategoriService;

    @Autowired
    PemasokService pemasokService;

    @Autowired
    ProdukService produkService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        Iterable<Kategori> k = kategoriService.getAllKategori();
        Iterable<Pemasok> p = pemasokService.getAllPemasok();
        Iterable<Produk> produk = produkService.getAllProduk();
        
        
        Iterable<Produk> rejectedProduk = produkService.getRejectedProduk();
        if (rejectedProduk != null) model.addAttribute("rejectedProduk", rejectedProduk);
        
        Iterable<Produk> getStokProduk = produkService.getStockOfProduk();
        if (getStokProduk != null) model.addAttribute("getStokProduk", getStokProduk);
        
        model.addAttribute("kategori", k);
        model.addAttribute("pemasok", p);
        model.addAttribute("produk", produk);

        return "product/product";
    }

    @GetMapping("/product/add-product")
    public String showAddProduct(Model model) {
        Iterable<Kategori> k = kategoriService.getAllKategori();
        Iterable<Pemasok> p = pemasokService.getAllPemasok();
        
       

        
        model.addAttribute("kategori", k);
        model.addAttribute("pemasok", p);
        return "product/add-product";
    }

    @GetMapping("/product/edit-product/{id}")
    public String showEditProduct(@PathVariable("id") Integer id, Model model) {
        Produk p = produkService.getOne(id);
        Iterable<Kategori> k = kategoriService.getAllKategori();
        Iterable<Pemasok> pemasok = pemasokService.getAllPemasok();

        model.addAttribute("produk", p);
        model.addAttribute("kategori", k);
        model.addAttribute("pemasok", pemasok);
        return "product/edit-product";
    }

    @PostMapping("/product/saveproduct")
    public String saveProduct(
            @RequestParam("namaproduk") String nama,
            @RequestParam("harga_jual") Integer harga_jual,
            @RequestParam("harga_awal") Integer harga_awal,
            @RequestParam("stok") Integer stok,
            @RequestParam("kategori") Integer kategori,
            @RequestParam("pemasok") Integer pemasok,
            @RequestParam("gambar_produk") MultipartFile multipartFile
    ) throws IOException {
        produkService.saveProduk(nama, harga_jual, harga_awal,
                stok, kategori, pemasok, multipartFile);
        return "redirect:/products";
    }

    @GetMapping("/product/getOneProduct/{id}")
    @ResponseBody
    public Produk getOneProduct(@PathVariable(value = "id") Integer id) {
        Produk produk = produkService.getOne(id);
        return produk;
    }

    @PostMapping("/product/updateproduct/{id}")
    public String updateProduct(@PathVariable("id") Integer id,
            @RequestParam("nama_produk") String nama_produk,
            @RequestParam("harga_awal") Integer harga_awal,
            @RequestParam("harga_jual") Integer harga_jual,
            @RequestParam("stok") Integer stok,
            @RequestParam("kategori") Integer kategori,
            @RequestParam("pemasok") Integer pemasok,
            @RequestParam("gambar_produk") MultipartFile gambar_produk
    ) throws IOException {
        produkService.updateProduk(id, nama_produk, harga_jual, harga_awal,
                stok, kategori, pemasok, gambar_produk);
        return "redirect:/products";
    }
    
    
    @GetMapping("product/rejected-product")
    public String rejectedProduk(Model model){
    
        
       
         return "product/product";
    }
}
