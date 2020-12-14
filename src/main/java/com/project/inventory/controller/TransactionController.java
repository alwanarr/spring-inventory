/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.inventory.config.EntityIdResolver;
import com.project.inventory.entity.Transaksi;
import com.project.inventory.exception.ProdukReduceException;
import com.project.inventory.service.TransaksiService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author i am me
 */
@Controller
public class TransactionController {
    @Autowired
    TransaksiService transaksiService;
    
    
//    @PostMapping("/admin/savetransaction")
//    @ResponseBody
//    public void saveTransaction(
////        @RequestParam("jumlah_order") Integer jumlah_order,
////        @RequestParam("total_harga") Integer total_harga,
////        @RequestParam("produk_id") Integer produk_id,
////        @RequestParam("tanggal") String tanggal,
////        @RequestParam("pelanggan_id") Integer pelanggan_id     
//          @RequestParam("data") String[] data
//    ){
////        Transaksi t = transaksiService.saveTransaction(jumlah_order, total_harga,
////                                    produk_id, tanggal, pelanggan_id);
//        System.out.println("data "+ data);
//    }
    
    @PostMapping("/admin/savetransaction")
    @ResponseBody
    public ResponseEntity<String> saveAllTransaksi(@RequestBody List<Transaksi> transaksiList){
        try{
            transaksiService.saveAllTransaksi(transaksiList);
        }catch( ProdukReduceException p){
            return new ResponseEntity<>( p.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        
        return new ResponseEntity<>("sukses", HttpStatus.CREATED);
    }
}
