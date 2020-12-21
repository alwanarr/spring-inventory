/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.itextpdf.text.DocumentException;
import com.project.inventory.config.PDFGenerator;
import com.project.inventory.config.TanggalAndTotalharga;
import com.project.inventory.entity.Kategori;
import com.project.inventory.entity.Produk;
import com.project.inventory.entity.Tipe;
import com.project.inventory.entity.Transaksi;
import com.project.inventory.entity.User;
import com.project.inventory.repository.KategoriRepository;
import com.project.inventory.repository.ProdukRepository;
import com.project.inventory.repository.TipeRepository;
import com.project.inventory.service.KategoriService;
import com.project.inventory.service.TipeService;
import com.project.inventory.service.TransaksiService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    TransaksiService transaksiService;
    
    @Autowired
    KategoriRepository kategoriRepo;

    @Autowired
    ProdukRepository produkRepo;
    
    @Autowired
    TipeRepository tipeRepo;
//    
//    @GetMapping("/admin/getOneTipe/{id}")
//    @ResponseBody
//    public Tipe getOneTipe(@PathVariable(value = "id") Integer id){
//        Tipe tipe = tipeService.getOneTipe(id);
//        return tipe;
//    }

    @GetMapping(value = "/products/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> productsReport() throws IOException {
        List<Produk> products = (List<Produk>) produkRepo.findAll();
        ByteArrayInputStream bis = PDFGenerator.produkReport(products);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Laporan-produk.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/traksaksi/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getReportOfTransactions() throws IOException {
        List<TanggalAndTotalharga> reports = transaksiService.getReport();
        ByteArrayInputStream bis = PDFGenerator.transactionReport(reports);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Laporan-transaksi.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(bis));
    }

//    @GetMapping("/kategori/{id}/tipe")
//    public Optional<Kategori> getKategoriTipe(@PathVariable("id") Integer id){
//        
//       Optional<Kategori> kategori = kategoriRepo.findById(id);
//       if(kategori.isPresent()){
//           return  kategori;
//       } 
//        return null;
//    }
    

}
