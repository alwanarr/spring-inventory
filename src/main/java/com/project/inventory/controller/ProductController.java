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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        Iterable<Produk> rejectedProduk = produkService.getProdukByStatus(3);
        if (rejectedProduk != null) {
            model.addAttribute("rejectedProduk", rejectedProduk);
        }

        Iterable<Produk> getStokProduk = produkService.getStockOfProduk();
        if (getStokProduk != null) {
            model.addAttribute("getStokProduk", getStokProduk);
        }

        Iterable<Produk> accProducts = produkService.getProdukByStatus(1);
        if (accProducts != null) {
            model.addAttribute("accproducts", accProducts);
        }

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
        Produk produkForm = new Produk();

        model.addAttribute("produk", p);
        model.addAttribute("kategori", k);
        model.addAttribute("pemasok", pemasok);
        model.addAttribute("produkForm", produkForm);
        return "product/edit-product";
    }

    @PostMapping("/product/saveproduct")
    public String saveProduct(
            @RequestParam("namaproduk") @NotBlank String nama,
            @RequestParam("harga_jual") @Min(1) Integer harga_jual,
            @RequestParam("harga_awal") @Min(1) Integer harga_awal,
            @RequestParam("stok") @Min(1) Integer stok,
            @RequestParam("kategori") Integer kategori,
            @RequestParam("pemasok") Integer pemasok,
            @RequestParam("gambar_produk") MultipartFile multipartFile,
            RedirectAttributes atts
    ) throws IOException, Exception {
        
        if(multipartFile.getContentType() != "image/jpeg" && 
                multipartFile.getContentType() != "image/jpeg"){
            throw new Exception("formulir yang anda kirim bukan berupa gambar");
        }
        
        produkService.saveProduk(nama, harga_jual, harga_awal,
                stok, kategori, pemasok, multipartFile);
       
        atts.addFlashAttribute("success", "Berhasil menyimpan data produk");
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
    public String rejectedProduk(Model model) {

        return "product/product";
    }
    
    @GetMapping("/produk/delete/{id}")
    public String deleteProduk(@PathVariable("id") Integer id){
        produkService.deleteById(id);
        return "redirect:/products";
    }
}
