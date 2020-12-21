/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.entity.Pelanggan;
import com.project.inventory.entity.Transaksi;
import com.project.inventory.service.PelangganService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author i am me
 */
@Controller
public class CustomerController {

    @Autowired
    PelangganService pelangganService;

    @GetMapping("/admin/customers")
    @ResponseBody
    public List getAllCustomers(@RequestParam("search") String search) {

        List<Pelanggan> p = pelangganService.getPelangganByNoHp(search);
//        List no_hp = new ArrayList();
//        for (Pelanggan pelanggan : p) {
//             no_hp.add(pelanggan.getNoHp());
//        }

        return p;

    }

    @PostMapping("/admin/savecustomer")
    @ResponseBody
    public Integer saveCustomer(
            @RequestParam("no_hp") String no_hp,
            @RequestParam("nama") String nama,
            @RequestParam("email") String email,
            @RequestParam("alamat") String alamat
    ) {
       
        System.out.println("masuk customer create");
        Pelanggan p = pelangganService.saveCustomer(nama, no_hp, alamat, email);
        System.out.println("id "+ p.getIdPelanggan());
        return p.getIdPelanggan();
    }
    
    

    @GetMapping("/nyoba")
    public String nyoba() {
        
	
        return "order/nyoba";
    }
}
